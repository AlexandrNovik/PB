package aliak.dev.domain.interactions

import aliak.dev.domain.executors.PostExecutionThread
import aliak.dev.domain.executors.ThreadExecutor
import rx.Observable
import javax.inject.Inject

class SitPlayerAtTableUseCase @Inject constructor(jobExecutor: ThreadExecutor,
                                                  postExecutionThread: PostExecutionThread)
    : UseCase<Unit, Unit>(jobExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(param: Unit): Observable<Unit> {
        return Observable.just(Unit)
    }
}