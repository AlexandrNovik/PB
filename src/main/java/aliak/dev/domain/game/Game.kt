package aliak.dev.domain.game

class Game(val type: GameType,
           val size: GameSize) {

    sealed class GameType {
        class Cash : GameType()
        class SitAndGo : GameType()
        class Tournament : GameType()
    }

    sealed class GameSize(val maxSeats: Int) {
        class FullRing : GameSize(10)
        class ShortHanded : GameSize(6)
    }
}