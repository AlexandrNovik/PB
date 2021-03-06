package aliak.dev.domain.player

import aliak.dev.domain.game.Position
import aliak.dev.domain.game.TablePosition
import aliak.dev.extensions.log
import rx.Observable
import rx.subjects.BehaviorSubject
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokerPlayerManager @Inject constructor() : PlayerManger {

    private val state = BehaviorSubject.create<PlayerState>(PlayerState())
    private val actionSubject = BehaviorSubject.create<Action>()

    init {
        actionSubject
                .scan(PlayerState(), { state, action -> action.execute(state) })
                .filter { it.modifiedPlayer != null }
                .doOnNext { state.onNext(it) }
                .subscribe()
    }

    override fun addPlayer(player: BasePlayer) {
        log("${player.name} was added")
        actionSubject.onNext(Action.AddPlayerAction(player))
    }

    override fun removePlayer(player: BasePlayer) {
        log("${player.name} was removed")
        actionSubject.onNext(Action.RemovePlayerAction(player))
    }

    override fun assignPositions() {
        log("Assign positions")
        actionSubject.onNext(Action.AssignShortPositionsAction())
    }

    fun getPlayers() = state.value.players

    fun observeState(): Observable<PlayerState> = state.asObservable()

    data class PlayerState(var players: HashSet<BasePlayer> = HashSet(),
                           var modifiedPlayer: BasePlayer? = null,
                           var added: Boolean = false,
                           var removed: Boolean = false)

    private sealed class Action {
        abstract fun execute(state: PlayerState): PlayerState

        class AddPlayerAction(val player: BasePlayer) : Action() {
            override fun execute(state: PlayerState): PlayerState {
                return state.copy().apply {
                    players.add(player)
                    modifiedPlayer = player
                    added = true
                    removed = false
                }
            }
        }

        class RemovePlayerAction(val player: BasePlayer) : Action() {
            override fun execute(state: PlayerState): PlayerState {
                return state.copy().apply {
                    players.remove(player)
                    modifiedPlayer = player
                    removed = true
                    added = false
                }
            }
        }

        class AssignShortPositionsAction : Action() {
            override fun execute(state: PlayerState): PlayerState {
                return state.copy().apply {
                    var prevPosition: Position = Position.ShortHandedPosition(TablePosition.UTG_1)
                    val pl = players.toList().sortedBy { basePlayer -> basePlayer.seatPosition }
                    pl.forEach {
                        if (it.seatPosition == 1) {
                            it.position = Position.ShortHandedPosition(TablePosition.UTG_1)
                        } else {
                            it.position = Position.ShortHandedPosition(prevPosition.next())
                            prevPosition = Position.ShortHandedPosition(prevPosition.next())
                        }
                    }
                    players = pl.toHashSet()
                }
            }
        }
    }
}
