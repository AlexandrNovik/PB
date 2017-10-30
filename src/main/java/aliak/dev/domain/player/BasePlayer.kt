package aliak.dev.domain.player

import aliak.dev.domain.game.Position

open class BasePlayer(val name: String = "NoName") {
    lateinit var position: Position
    var seatPosition: Int = 0
}
