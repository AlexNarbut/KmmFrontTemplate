package ru.narbut.kmmfronttemp.presentation.app.splash

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.inject
import domain.TestRepository
import ru.narbut.kmmfronttemp.presentation.navigation.component.ViewModelRetainComponent

class SplashScreenComponent(
    componentContext: ComponentContext
) : ViewModelRetainComponent<SplashViewModel>(componentContext) {
    private val testRepository: TestRepository by inject()

    override val viewModelFactory: () -> SplashViewModel
        get() = { SplashViewModel(testRepository) }

    @Composable
    override fun render() {
        SplashScreen(viewModel)
    }
}