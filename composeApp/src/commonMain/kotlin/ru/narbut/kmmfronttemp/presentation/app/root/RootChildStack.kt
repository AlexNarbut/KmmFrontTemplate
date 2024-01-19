package ru.narbut.kmmfronttemp.presentation.app.root

import com.arkivanov.decompose.router.stack.replaceCurrent
import ru.narbut.kmmfronttemp.presentation.navigation.component.ChildStackComponent
import ru.narbut.kmmfronttemp.presentation.navigation.component.DefaultChildStack

class RootChildStack(
    component: ChildStackComponent<RootComponentChildStack.Config>,
) : DefaultChildStack<RootComponentChildStack.Config>(
    component,
    RootChildStack::class.simpleName!!,
    RootComponentChildStack.Config.serializer()
) {
    fun startAuthApp() {
        navigator.replaceCurrent(RootComponentChildStack.Config.NoAuthApp)
    }

    fun startMainApp() {
        navigator.replaceCurrent(RootComponentChildStack.Config.MainApp)
    }
}