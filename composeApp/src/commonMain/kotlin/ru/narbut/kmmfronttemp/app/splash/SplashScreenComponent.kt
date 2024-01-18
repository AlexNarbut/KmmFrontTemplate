package ru.narbut.kmmfronttemp.app.splash

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.inject
import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.navigation.component.ViewModelRetainComponent

class SplashScreenComponent(
    componentContext: ComponentContext
) : ViewModelRetainComponent<SplashViewModel>(componentContext) {
    private val networkRepository: NetworkRepository by inject()

    override val viewModelFactory: () -> SplashViewModel
        get() = { SplashViewModel(networkRepository) }

    @Composable
    override fun render() {
        SplashScreen(viewModel)
    }
}