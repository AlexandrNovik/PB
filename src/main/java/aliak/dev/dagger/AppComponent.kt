package aliak.dev.dagger

import aliak.dev.domain.game.MainGame
import aliak.dev.presentation.Table
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(table: Table)
    fun inject(main: MainGame)
}