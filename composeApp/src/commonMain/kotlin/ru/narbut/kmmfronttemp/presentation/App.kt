package ru.narbut.kmmfronttemp.presentation

import androidx.compose.runtime.Composable
import ru.narbut.kmmfronttemp.presentation.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.presentation.theme.AppTheme

@Composable
internal fun App(component: RootComponentChildStack) = AppTheme {
    component.render()
}


internal expect fun openUrl(url: String?)