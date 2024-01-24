package ru.narbut.kmmfronttemp.presentation.app.splash

import kotlinx.coroutines.Job
import domain.TestRepository
import ru.narbut.kmmfronttemp.presentation.navigation.component.ViewModel

class SplashViewModel(testRepository: TestRepository) : ViewModel(){

    private var syncJob: Job? = null

    init {
        println("init Splash")
        sync()
    }

    override fun onResume() {
        super.onResume()
        println("onResume Splash")
    }

    override fun onPause() {
        super.onPause()
        println("onPause Splash")
    }

    override fun onStart() {
        super.onStart()
        println("onStart Splash")
    }

    override fun onStop() {
        super.onStop()
        println("onStop Splash")
    }

    override fun destroy() {
        super.destroy()
        println("destroy Splash")
    }

    fun sync() {
        syncJob?.cancel()
        syncJob = safeLaunch {
            ru.narbut.kmmfronttemp.presentation.app.AppState.checkIfUserIsLoggedIn()
        }
    }
}