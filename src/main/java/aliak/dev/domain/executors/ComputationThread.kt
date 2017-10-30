package aliak.dev.domain.executors

import rx.Scheduler
import rx.schedulers.Schedulers
import javax.inject.Inject

class ComputationThread @Inject constructor() : PostExecutionThread {

    override fun getScheduler(): Scheduler = Schedulers.computation()
}