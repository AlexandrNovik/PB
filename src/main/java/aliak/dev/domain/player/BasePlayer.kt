package aliak.dev.domain.player

import aliak.dev.domain.game.Position
import aliak.dev.domain.game.TablePosition

open class BasePlayer(val name: String = "NoName") {
    lateinit var position: Position
    var seatPosition: Int = 0

    class EmptyPlayer : BasePlayer(name = "empty") {
        init {
            position = Position.ShortHandedPosition(TablePosition.UTG_1)
        }
    }

    override fun toString(): String =
            "Player(name='$name', position=$position, seatPosition=$seatPosition)"
}
