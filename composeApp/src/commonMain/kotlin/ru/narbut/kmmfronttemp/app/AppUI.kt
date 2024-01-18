package ru.narbut.kmmfronttemp.app

import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.narbut.kmmfronttemp.theme.AppContext
import ru.narbut.kmmfronttemp.theme.DEFAULT_APP_DIMENS
import ru.narbut.kmmfronttemp.theme.DimensImpl

object AppUI {
    private val _appContext = MutableStateFlow(Context(DEFAULT_APP_DIMENS.getDimensClass()))

    val appContext = _appContext.asStateFlow()
    
    fun<C: Any, T: Any> defaultStackTransitionAnimation(): StackAnimation<C, T> = stackAnimation(fade())

    private fun Context(dimensImpl: DimensImpl) = AppContext(dimensImpl)
}