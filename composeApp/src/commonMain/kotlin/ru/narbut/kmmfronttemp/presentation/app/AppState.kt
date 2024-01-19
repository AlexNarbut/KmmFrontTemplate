package ru.narbut.kmmfronttemp.presentation.app

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import ru.narbut.kmmfronttemp.presentation.navigation.component.GlobalErrorHandler


object AppState : KoinComponent {

    private val isUserLoggedInMutable = MutableStateFlow<Boolean?>(null)
    val isUserLoggedIn = ru.narbut.kmmfronttemp.presentation.app.AppState.isUserLoggedInMutable.asStateFlow()

    private val globalErrorHandler = CoroutineExceptionHandler { _, exception ->
//        if (exception is UnauthorizedException
//            || exception is NetworkTokenIsExpired
//            || exception is NoApiKeyException) {
//            doLogout()
//        }
//        Log.e { exception.toString() }
    }


    init {
        GlobalErrorHandler.globalErrorHandler =
            ru.narbut.kmmfronttemp.presentation.app.AppState.globalErrorHandler
    }

    suspend fun checkIfUserIsLoggedIn() {
        delay(500)
        //val response = execute(authInteractor.checkIfUserLoggedInUseCase)
        ru.narbut.kmmfronttemp.presentation.app.AppState.isUserLoggedInMutable.value = true
    }

    fun doLogout() {
        ru.narbut.kmmfronttemp.presentation.app.AppState.isUserLoggedInMutable.value = false
    }
}
