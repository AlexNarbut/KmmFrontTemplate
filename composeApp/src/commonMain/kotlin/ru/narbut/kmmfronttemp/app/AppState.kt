package ru.narbut.kmmfronttemp.app

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import ru.narbut.kmmfronttemp.navigation.component.GlobalErrorHandler


object AppState : KoinComponent {

    private val isUserLoggedInMutable = MutableStateFlow<Boolean?>(null)
    val isUserLoggedIn = isUserLoggedInMutable.asStateFlow()

    private val globalErrorHandler = CoroutineExceptionHandler { _, exception ->
//        if (exception is UnauthorizedException
//            || exception is NetworkTokenIsExpired
//            || exception is NoApiKeyException) {
//            doLogout()
//        }
//        Log.e { exception.toString() }
    }


    init {
        GlobalErrorHandler.globalErrorHandler = globalErrorHandler
    }

    suspend fun checkIfUserIsLoggedIn() {
        delay(500)
        //val response = execute(authInteractor.checkIfUserLoggedInUseCase)
        isUserLoggedInMutable.value = true
    }

    fun doLogout() {
        isUserLoggedInMutable.value = false
    }
}
