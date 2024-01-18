package ru.narbut.kmmfronttemp.app.auth.main

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.inject
import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.navigation.component.ViewModelRetainComponent

class MainScreenComponent(
    componentContext: ComponentContext
) : ViewModelRetainComponent<MainViewModel>(componentContext) {
    private val networkRepository: NetworkRepository by inject()

    override val viewModelFactory: () -> MainViewModel
        get() = { MainViewModel(networkRepository) }

    @Composable
    override fun render() {
        MainScreen(viewModel)
    }
}