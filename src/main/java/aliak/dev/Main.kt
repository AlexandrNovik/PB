package aliak.dev

import aliak.dev.domain.game.MainGame
import aliak.dev.presentation.Table

fun main(args: Array<String>) {
    Table().apply { show() }
    MainGame().apply { startGame() }
}