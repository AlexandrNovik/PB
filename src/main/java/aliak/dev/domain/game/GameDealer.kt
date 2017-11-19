package aliak.dev.domain.game

import aliak.dev.domain.player.BasePlayer
import aliak.dev.extensions.log
import rx.Observable
import rx.subjects.BehaviorSubject
import rx.subjects.PublishSubject

class GameDealer : Dealer {
    private val action = PublishSubject.create<DealerAction>()
    private val state = BehaviorSubject.create<DealerState>()

    init {
        action
                .scan(DealerState(), { state, action -> action.execute(state) })
                .subscribe({
                    state.onNext(it)
                })
    }

    fun observeDealerState(): Observable<DealerState> = state.asObservable()

    override fun startGame() {
        log("Game started")
        action.onNext(DealerAction.StartGameAction())
    }

    override fun shuffleDeck() {
        log("Shuffle deck")
        action.onNext(DealerAction.ShuffleDeckAction())
    }

    override fun startRound() {
        log("Round started")
        action.onNext(DealerAction.StartRoundAction())
    }

    override fun startMove(player: BasePlayer) {
        log("${player.name} move started")
        action.onNext(DealerAction.StartMoveAction(player))
    }

    override fun endMove() {
        log("Move ended")
        action.onNext(DealerAction.EndMoveAction())
    }

    override fun openFlop() {
        log("Open flop")
        action.onNext(DealerAction.OpenFlopAction())
    }

    override fun openTurn() {
        log("Open turn")
        action.onNext(DealerAction.OpenTurnAction())
    }

    override fun openRiver() {
        log("Open river")
        action.onNext(DealerAction.OpenRiverAction())
    }

    override fun compareHands() {
        log("Compare hands")
        action.onNext(DealerAction.CompareHandsAction())
    }

    override fun declareWinner(player: BasePlayer) {
        log("Declare winner")
        action.onNext(DealerAction.DeclareWinnerAction(player))
    }

    override fun endRound() {
        log("End round")
        action.onNext(DealerAction.EndRoundAction())
    }

    abstract sealed class DealerAction {
        abstract fun execute(state: DealerState): DealerState
        class StartGameAction : DealerAction() {
            override fun execute(state: DealerState) = DealerState(
                    gameStarted = true)
        }

        class StartRoundAction : DealerAction() {
            override fun execute(state: DealerState) = DealerState(
                    gameStarted = state.gameStarted)
        }

        class ShuffleDeckAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(deckShuffled = true)
        }

        class StartMoveAction(private val player: BasePlayer) : DealerAction() {
            override fun execute(state: DealerState) = state.copy(
                    activePlayer = player,
                    startMove = true)
        }

        class EndMoveAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(startMove = false)
        }

        class OpenFlopAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(gameStage = GameStage.FLOP)
        }

        class OpenTurnAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(gameStage = GameStage.TURN)
        }

        class OpenRiverAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(gameStage = GameStage.RIVER)
        }

        class CompareHandsAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(needCompareHands = true)
        }

        class DeclareWinnerAction(private val player: BasePlayer) : DealerAction() {
            override fun execute(state: DealerState) = state.copy(winner = player)
        }

        class EndRoundAction : DealerAction() {
            override fun execute(state: DealerState) = state.copy(endRound = true)
        }
    }

    data class DealerState(var activePlayer: BasePlayer = BasePlayer.EmptyPlayer(),
                           var startMove: Boolean = false,
                           var gameStage: GameStage = GameStage.PRE_FLOP,
                           var deckShuffled: Boolean = false,
                           var needCompareHands: Boolean = false,
                           var winner: BasePlayer = BasePlayer.EmptyPlayer(),
                           var endRound: Boolean = false,
                           var gameStarted: Boolean = false)
}