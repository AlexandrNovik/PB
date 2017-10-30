package aliak.dev.domain.game

interface Dealer {
    fun startGame()
    fun shuffleDeck()
    fun startRound()
    fun startMove()
    fun endMove()
    fun openFlop()
    fun openTurn()
    fun openRiver()
    fun compareHands()
    fun declareWinner()
    fun endRound()
}