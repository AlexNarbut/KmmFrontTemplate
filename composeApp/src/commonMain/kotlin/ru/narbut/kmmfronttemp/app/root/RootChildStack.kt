package ru.narbut.kmmfronttemp.app.root

import com.arkivanov.decompose.router.stack.replaceCurrent
import ru.narbut.kmmfronttemp.navigation.component.ChildStackComponent
import ru.narbut.kmmfronttemp.navigation.component.DefaultChildStack

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