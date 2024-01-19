@file:Suppress("UNCHECKED_CAST")

package ru.narbut.kmmfronttemp.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.lifecycle.*
import org.koin.core.component.KoinComponent

abstract class ViewModelComponent(
    protected val componentContext: ComponentContext,
): UIComponent, ComponentContext by componentContext , KoinComponent{

    abstract val viewModel: ViewModel

    init {
        componentContext.lifecycle
            .doOnStart {
                viewModel?.onStart()
            }
        componentContext.lifecycle
            .doOnStop {
                viewModel?.onStop()
            }

        componentContext.lifecycle
            .doOnResume {
                viewModel?.onResume()
            }
        componentContext.lifecycle
            .doOnPause {
                viewModel?.onPause()
            }

        componentContext.lifecycle
            .doOnDestroy {
                viewModel?.destroy()
            }
    }
}

abstract class ViewModelRetainComponent<VM : ViewModel>(
    private val componentContext: ComponentContext,
) : UIComponent, ComponentContext by componentContext, KoinComponent {

    protected abstract val viewModelFactory: () -> VM
    protected val viewModel: VM by lazy { instanceKeeper.getOrCreate("VM") { viewModelFactory() } }

    init {
        componentContext.lifecycle
            .doOnStart {
                viewModel?.onStart()
            }
        componentContext.lifecycle
            .doOnStop {
                viewModel?.onStop()
            }

        componentContext.lifecycle
            .doOnResume {
                viewModel?.onResume()
            }
        componentContext.lifecycle
            .doOnPause {
                viewModel?.onPause()
            }

        componentContext.lifecycle
            .doOnDestroy {
                viewModel?.destroy()
            }
    }
}

private fun <T : InstanceKeeper.Instance> InstanceKeeper.getOrCreate(key: Any, factory: () -> T): T {
    var instance: T? = get(key) as T?
    if (instance == null) {
        instance = factory()
        put(key, instance)
    }

    return instance
}