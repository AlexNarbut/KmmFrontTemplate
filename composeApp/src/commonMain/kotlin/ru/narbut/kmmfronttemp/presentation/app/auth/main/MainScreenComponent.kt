package ru.narbut.kmmfronttemp.presentation.app.auth.main

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.inject
import ru.narbut.kmmfronttemp.presentation.data.TestRepository
import ru.narbut.kmmfronttemp.presentation.navigation.component.ViewModelRetainComponent

class MainScreenComponent(
    componentContext: ComponentContext
) : ViewModelRetainComponent<MainViewModel>(componentContext) {
    private val testRepository: TestRepository by inject()

    override val viewModelFactory: () -> MainViewModel
        get() = { MainViewModel(testRepository) }

    @Composable
    override fun render() {
        MainScreen(viewModel)
    }
}