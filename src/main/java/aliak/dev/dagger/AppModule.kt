package aliak.dev.dagger

import aliak.dev.domain.executors.JobExecutor
import aliak.dev.domain.executors.PostExecutionThread
import aliak.dev.domain.executors.ThreadExecutor
import aliak.dev.domain.executors.ComputationThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(computationThread: ComputationThread): PostExecutionThread {
        return computationThread
    }
}