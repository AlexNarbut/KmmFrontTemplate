package ru.narbut.kmmfronttemp.presentation.app.splash

import MainText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.narbut.kmmfronttemp.presentation.ui.CustomScaffold

@Composable
fun SplashScreen(
    viewModel: SplashViewModel
){
    Scaffold  { padding ->
        CustomScaffold(
            title = "Splash",
            modifier = Modifier.fillMaxSize().padding(padding)
        ){
            Box {
                MainText("Splash")
            }
        }
    }
}