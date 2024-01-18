package ru.narbut.kmmfronttemp.app.splash

import kotlinx.coroutines.Job
import ru.narbut.kmmfronttemp.app.AppState
import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.navigation.component.ViewModel

class SplashViewModel(networkRepository: NetworkRepository) : ViewModel(){

    private var syncJob: Job? = null

    init {
        sync()
    }

    fun sync() {
        syncJob?.cancel()
        syncJob = safeLaunch {
            AppState.checkIfUserIsLoggedIn()
        }
    }
}