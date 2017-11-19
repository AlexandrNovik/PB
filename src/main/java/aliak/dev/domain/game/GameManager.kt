package aliak.dev.domain.game

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

        playerManger
                .observeState()
                .subscribe()
    }

    fun initPlayers() {
        // TODO: add players and start
    }

    fun start() {
        dealer.startGame(playerManger.getPlayers().toList())
    }
}