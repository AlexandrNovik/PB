package aliak.dev.domain.game

import aliak.dev.domain.game.PositionType.*
import aliak.dev.domain.game.TablePosition.*

abstract sealed class Position constructor(val position: TablePosition) {
    fun next(): TablePosition = nextPosition(position)
    abstract fun nextPosition(position: TablePosition): TablePosition
    override fun toString(): String = "Position(position=$position)"

    class FullRingPosition(position: TablePosition) : Position(position) {
        private val map = hashMapOf(
                Pair(UTG_1, UTG_2),
                Pair(UTG_2, UTG_3),
                Pair(UTG_3, MP_1),
                Pair(MP_1, MP_2),
                Pair(MP_2, MP_3),
                Pair(MP_3, CUT_OFF),
                Pair(CUT_OFF, DIALER),
                Pair(DIALER, SMALL_BLIND),
                Pair(SMALL_BLIND, BIG_BLIND),
                Pair(BIG_BLIND, UTG_1))

        override fun nextPosition(position: TablePosition): TablePosition = map[position]!!
    }

    class ShortHandedPosition(position: TablePosition) : Position(position) {
        private val map = hashMapOf(
                Pair(UTG_1, MP_1),
                Pair(MP_1, CUT_OFF),
                Pair(CUT_OFF, DIALER),
                Pair(DIALER, SMALL_BLIND),
                Pair(SMALL_BLIND, BIG_BLIND),
                Pair(BIG_BLIND, UTG_1))

        override fun nextPosition(position: TablePosition): TablePosition = map[position]!!
    }

}

enum class TablePosition(val type: PositionType) {
    UTG_1(EARLY),
    UTG_2(EARLY),
    UTG_3(EARLY),
    MP_1(MIDDLE),
    MP_2(MIDDLE),
    MP_3(MIDDLE),
    CUT_OFF(LATE),
    DIALER(LATE),
    SMALL_BLIND(BLIND),
    BIG_BLIND(BLIND)
}

enum class PositionType {
    EARLY, MIDDLE, LATE, BLIND
}