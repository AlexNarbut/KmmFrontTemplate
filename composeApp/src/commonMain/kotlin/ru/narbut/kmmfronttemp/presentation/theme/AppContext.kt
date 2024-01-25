package ru.narbut.kmmfronttemp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.flow.StateFlow

expect class AppContext {
    val dimens: DimensImpl
}

private object ContextProvider {
    var _appAppContext: StateFlow<AppContext>? = null
    val appContext get() = _appAppContext!!

}

val LocalAppContext = staticCompositionLocalOf {
    ContextProvider.appContext.value
}

fun initContext(appContext: StateFlow<AppContext>) {
    ContextProvider._appAppContext = appContext
}

@Composable
fun composableDimens(): DimensImpl {
    return LocalAppContext.current.dimens
}

val Dimens
    @Composable
    get() = LocalAppContext.current.dimens

fun dimens(): DimensImpl {
    return ContextProvider.appContext.value.dimens
}