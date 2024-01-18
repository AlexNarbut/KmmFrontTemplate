package ru.narbut.kmmfronttemp

import androidx.compose.runtime.Composable
import ru.narbut.kmmfronttemp.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.theme.AppTheme

@Composable
internal fun App(rootUIComponent: RootComponentChildStack) = AppTheme {
    rootUIComponent.render()
}


internal expect fun openUrl(url: String?)