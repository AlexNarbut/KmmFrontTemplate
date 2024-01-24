package ru.narbut.kmmfronttemp.presentation.app.root

import domain.TestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.narbut.kmmfronttemp.presentation.navigation.component.ViewModel


class RootViewModel (
    private val testRepository: TestRepository
) : ViewModel() {

    private val _initializingState = MutableStateFlow<InitializingState>(InitializingState.Initializing)
    val initializingState = _initializingState.asStateFlow()

    init {
        initializeSpecialistApp()
    }

    private fun initializeSpecialistApp() {
        safeLaunch {
            _initializingState.value = InitializingState.Initializing
            initAppLanguage()
            initConfLanguage()
            initAppTheme()
            initAppTextSize()
            _initializingState.value = InitializingState.Ready
        }
    }

    private suspend fun initAppLanguage(){
//        val lang = AppUIStateInteractor.getAppLanguage()
//        AppUIStateInteractor.setAppLanguage(lang)
//        AppUI.updateLanguage(lang)
    }

    private suspend fun initConfLanguage(){
//        val lang = AppUIStateInteractor.getConfigurationsLanguage()
//        AppUIStateInteractor.setConfigurationsLanguage(lang)
    }

    private suspend fun initAppTheme(){
//        val theme = AppUIStateInteractor.getAppTheme()
//        AppUIStateInteractor.setAppTheme(theme)
//        AppUI.updateTheme(theme)
    }

    private suspend fun initAppTextSize(){
//        val textSize = AppUIStateInteractor.getAppDimensSize()
//        AppUIStateInteractor.setAppDimensSize(textSize)
//        AppUI.updateDimensSize(textSize)
    }


    override fun onDestroy() = Unit
}


sealed class InitializingState {
    data object Initializing : InitializingState()
    data object Ready : InitializingState()
}