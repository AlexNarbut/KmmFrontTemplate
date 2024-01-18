package ru.narbut.kmmfronttemp.app.auth.main

import MainPrimaryText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.narbut.kmmfronttemp.ui.CustomScaffold

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    Scaffold { padding ->
        CustomScaffold(
            title = "Main title",
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Box {
                MainPrimaryText(
                    text = "MainScreen"
                )
            }
        }
    }
}