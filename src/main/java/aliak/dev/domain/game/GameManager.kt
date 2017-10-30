package aliak.dev.domain.game

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameManager @Inject constructor(val game: Game)