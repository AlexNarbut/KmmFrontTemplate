package ru.narbut.kmmfronttemp.presentation.app

import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.narbut.kmmfronttemp.presentation.theme.AppContext
import ru.narbut.kmmfronttemp.presentation.theme.DEFAULT_APP_DIMENS
import ru.narbut.kmmfronttemp.presentation.theme.DimensImpl

object AppUI {
    private val _appContext = MutableStateFlow(
        ru.narbut.kmmfronttemp.presentation.app.AppUI.Context(
            DEFAULT_APP_DIMENS.getDimensClass()
        )
    )

    val appContext = ru.narbut.kmmfronttemp.presentation.app.AppUI._appContext.asStateFlow()
    
    fun<C: Any, T: Any> defaultStackTransitionAnimation(): StackAnimation<C, T> = stackAnimation(fade())

    private fun Context(dimensImpl: DimensImpl) = AppContext(dimensImpl)
}