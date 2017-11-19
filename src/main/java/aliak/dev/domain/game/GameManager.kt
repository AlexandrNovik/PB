package aliak.dev.domain.game

import aliak.dev.domain.player.AiPlayer
import aliak.dev.domain.player.HumanPlayer
import aliak.dev.domain.player.PokerPlayerManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameManager @Inject constructor(private val playerManger: PokerPlayerManager) {
    private val dealer: GameDealer = GameDealer()

    init {
        dealer
                .observeDealerState()
                .subscribe()

//        TODO: need to be in table and interact with UI
//        playerManger
//                .observeState()
//                .subscribe()
    }

    fun initPlayers() {
        for (i in 1..5) {
            playerManger.addPlayer(AiPlayer(name = "Comp $i").apply { seatPosition = i })
        }
        playerManger.addPlayer(HumanPlayer(name = "Alex").apply { seatPosition = 6 })
        playerManger.assignPositions()
    }

    fun start() {
        dealer.startGame()
    }
}