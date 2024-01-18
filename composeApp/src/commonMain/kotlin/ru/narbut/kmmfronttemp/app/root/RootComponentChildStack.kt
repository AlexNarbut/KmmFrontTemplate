package ru.narbut.kmmfronttemp.app.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.Serializable
import org.koin.core.component.inject
import ru.narbut.kmmfronttemp.app.AppState
import ru.narbut.kmmfronttemp.app.auth.main.MainScreenComponent
import ru.narbut.kmmfronttemp.app.splash.SplashScreenComponent
import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.navigation.component.ChildStackComponent
import ru.narbut.kmmfronttemp.navigation.component.UIComponent
import ru.narbut.kmmfronttemp.navigation.component.ViewModelRetainComponent

class RootComponentChildStack(
    componentContext: ComponentContext,
) : ViewModelRetainComponent<RootViewModel>(componentContext),
    ChildStackComponent<RootComponentChildStack.Config> {

    private val rootScope = MainScope()

    override val initial = Config.Splash
    override val router = RootChildStack(this)

    private val networkRepository: NetworkRepository by inject()

    init {
        AppState.isUserLoggedIn
            .filterNotNull()
            .onEach { isLoggedIn ->
                if (isLoggedIn) {
                    router.startMainApp()
                } else {
                    router.startAuthApp()
                }
            }
            .launchIn(rootScope)

        lifecycle.doOnDestroy { rootScope.cancel() }
    }

    override val viewModelFactory: () -> RootViewModel
        get() = { RootViewModel(networkRepository) }

    @Composable
    override fun render() {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            val initializingState by viewModel.initializingState.collectAsState()

            when (initializingState) {
                InitializingState.Initializing -> {
                }

                InitializingState.Ready -> {
                    Box {
                        super.render()
                    }
                }
            }

        }
    }

    override fun childFactory(config: Config, componentContext: ComponentContext): UIComponent {
        return when (config) {
            Config.MainApp -> MainScreenComponent(componentContext)
            else -> SplashScreenComponent(componentContext)
        }
    }


    @Serializable
    sealed class Config {
        @Serializable
        data object Splash : Config()

        @Serializable
        data object MainApp : Config()

        @Serializable
        data object NoAuthApp : Config()
    }
}
