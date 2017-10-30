package aliak.dev.domain.interactions

import aliak.dev.domain.executors.PostExecutionThread
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.Subscription
import rx.observers.Subscribers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions
import java.util.concurrent.Executor

abstract class UseCase<in ParamType, ResultType> protected constructor(
        protected val scheduler: Scheduler,
        protected val postExecutionThread: Scheduler) {

    constructor(threadExecutor: Executor, postExecutionThread: PostExecutionThread)
            : this(Schedulers.from(threadExecutor), postExecutionThread.getScheduler())

    constructor(threadExecutor: Scheduler, postExecutionThread: PostExecutionThread)
            : this(threadExecutor, postExecutionThread.getScheduler())

    protected var subscription: Subscription = Subscriptions.empty()

    /**
     * Builds an [rx.Observable] which will be used when executing the current [UseCase].
     */
    abstract fun buildUseCaseObservable(param: ParamType): Observable<ResultType>

    /**
     * Executes the current use case.

     * @param useCaseSubscriber The guy who will be listen to the observable getRetrofit
     * * with [.buildUseCaseObservable].
     */
    open fun execute(param: ParamType, useCaseSubscriber: Subscriber<ResultType> = Subscribers.empty()) {
        subscription = buildUseCaseObservable(param)
                .subscribeOn(scheduler)
                .observeOn(postExecutionThread)
                .subscribe(useCaseSubscriber)
    }

    /**
     * Unsubscribes getViewTypeFrom current [rx.Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }
}