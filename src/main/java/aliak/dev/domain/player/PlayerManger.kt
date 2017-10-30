package aliak.dev.domain.player

interface PlayerManger {
    fun addPlayer(player: BasePlayer)
    fun removePlayer(player: BasePlayer)
}