package aliak.dev.dagger

import javax.inject.Singleton

@Singleton
class DaggerProvider {
    val appComponent: AppComponent = DaggerAppComponent.builder().build()

    companion object {
        val provider = DaggerProvider()
    }
}