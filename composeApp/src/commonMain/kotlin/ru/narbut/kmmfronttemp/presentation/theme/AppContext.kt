package ru.narbut.kmmfronttemp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.flow.StateFlow

expect class AppContext {
    val dimens: DimensImpl

    fun getString(resId: StringResource): String

    fun getString(resId: StringResource, vararg formatArgs: Any) : String
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
fun composableString(resId: StringResource): String {
    return LocalAppContext.current.getString(resId)
}

fun string(resId: StringResource): String {
    return ContextProvider.appContext.value.getString(resId)
}

@Composable
fun composableString(resId: StringResource, vararg formatArgs: Any): String {
    return LocalAppContext.current.getString(resId, formatArgs)
}

fun string(resId: StringResource, vararg formatArgs: Any): String {
    return ContextProvider.appContext.value.getString(resId, formatArgs)
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