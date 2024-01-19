package ru.narbut.kmmfronttemp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.flow.StateFlow

class AppContext(val dimensImpl: DimensImpl) {
//    fun getString(resId: Int): String {
//        return context.getString(resId)
//    }
//
//    fun getString(resId: Int, vararg formatArgs: Any): String {
//        return context.getString(resId, formatArgs)
//    }
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
    return LocalAppContext.current.dimensImpl
}

val Dimens
    @Composable
    get() = LocalAppContext.current.dimensImpl

fun dimens(): DimensImpl {
    return ContextProvider.appContext.value.dimensImpl
}