package aliak.dev.domain.game

import aliak.dev.dagger.DaggerProvider
import javax.inject.Inject

class MainGame {
    @Inject lateinit var gameManager: GameManager

    init {
        DaggerProvider.provider.appComponent.inject(this)
    }

    fun startGame() {
        gameManager.initPlayers()
        gameManager.start()
    }
}