package aliak.dev.domain.executors

import rx.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}