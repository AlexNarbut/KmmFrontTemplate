package ru.narbut.kmmfronttemp.presentation.navigation.component

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class ViewModel : InstanceKeeper.Instance, KoinComponent {
    protected val viewModelScope = MainScope()

    protected val proceedMutex: Mutex = Mutex()
    protected var proceedClicked: Boolean = false

    protected open val errorHandler = CoroutineExceptionHandler { context, exception ->
        GlobalErrorHandler.globalErrorHandler.handleException(context, exception)
        processCriticalError(exception)
    }

    open fun onResume() = Unit
    open fun onPause() = Unit
    open fun onStart() = Unit
    open fun onStop() = Unit

    open fun destroy() {
        onDestroy()
        viewModelScope.cancel()
    }

    protected open fun processCriticalError(exception: Throwable) {}

    protected fun safeLaunch(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(errorHandler) {
            block.invoke(this)
        }
    }

    protected fun safeLaunch(coroutineContext: CoroutineContext, block: suspend CoroutineScope.() -> Unit): Job {
        val context = if (coroutineContext[CoroutineExceptionHandler.Key] != null) {
            coroutineContext
        } else {
            coroutineContext + errorHandler
        }
        return viewModelScope.launch(context) {
            block.invoke(this)
        }
    }

    protected suspend fun executeWithProceedLock(
        needSkipAnother: Boolean = true,
        block: suspend () -> Unit
    ) {
        val canExecute = needSkipAnother && proceedMutex.isLocked
        if (canExecute) return
        proceedMutex.withLock {
            block.invoke()
        }
    }

    protected suspend fun <T> invokeWithDelay(delay: Long = CLICKED_DELAY, action: suspend () -> T): T {
        val result = action.invoke()
        delay(delay)
        return result
    }

    companion object {
        protected const val CLICKED_DELAY = 500L
    }
}