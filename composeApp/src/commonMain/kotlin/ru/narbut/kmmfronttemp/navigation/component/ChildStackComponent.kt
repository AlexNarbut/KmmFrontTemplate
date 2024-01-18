package ru.narbut.kmmfronttemp.navigation.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.serialization.KSerializer

interface ChildStackComponent<C : Any> : UIComponent, ComponentContext {
    val initial: C
    val router: DefaultChildStack<C>

    fun childFactory(config: C, componentContext: ComponentContext): UIComponent

    @Composable
    override fun render() {
        Children(
            stack = router.state
        ) { child ->
            child.instance.render()
        }
    }
}


open class DefaultChildStack<C : Any>(
    component: ChildStackComponent<C>,
    val name: String,
    serializer: KSerializer<C>
) {
    val navigator = StackNavigation<C>()
    init {
        ChildStackRegistry.put(
            name,
            component.childStack(
                source = navigator,
                serializer = serializer,
                initialStack = { listOf(component.initial) },
                key = name,
                handleBackButton = false,
                childFactory = component::childFactory
            )
        )

        component.lifecycle.doOnDestroy {
            ChildStackRegistry.remove(name)
        }
    }

    protected val router get() = ChildStackRegistry.getRouter<C>(name)

    val state = router

}

private object ChildStackRegistry {
    private val childStackMap: MutableMap<String, Value<ChildStack<*, *>>> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    fun <C : Any> getRouter(clazz: String): Value<ChildStack<C, UIComponent>> {
        return childStackMap[clazz] as Value<ChildStack<C, UIComponent>>
    }

    fun <C : Any> put(clazz: String, router: Value<ChildStack<C, UIComponent>>) {
        childStackMap[clazz] = router
    }

    fun remove(clazz: String) {
        childStackMap.remove(clazz)
    }
}