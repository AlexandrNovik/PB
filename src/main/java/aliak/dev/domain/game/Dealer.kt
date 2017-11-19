package aliak.dev.domain.game

import aliak.dev.domain.player.BasePlayer

interface Dealer {
    fun startGame(players: List<BasePlayer>)
    fun shuffleDeck()
    fun startRound()
    fun startMove(player: BasePlayer)
    fun endMove()
    fun openFlop()
    fun openTurn()
    fun openRiver()
    fun compareHands()
    fun declareWinner(player: BasePlayer)
    fun endRound()
}