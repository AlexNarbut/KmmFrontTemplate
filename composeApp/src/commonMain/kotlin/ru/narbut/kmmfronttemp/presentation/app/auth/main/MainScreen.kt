package ru.narbut.kmmfronttemp.presentation.app.auth.main

import MainPrimaryText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.narbut.kmmfronttemp.SharedRes
import ru.narbut.kmmfronttemp.presentation.theme.composableString
import ru.narbut.kmmfronttemp.presentation.ui.CustomScaffold
import ru.narbut.kmmfronttemp.presentation.ui.buttons.MainButton
import ru.narbut.kmmfronttemp.presentation.ui.image.SvgImage
import ru.narbut.kmmfronttemp.presentation.ui.loading.CrossLoadingWheel
import ru.narbut.kmmfronttemp.presentation.ui.switch.MainSwitch

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    Scaffold { scaffoldPadding ->
        CustomScaffold(
            title = "Main title",
            modifier = Modifier.fillMaxSize().padding(scaffoldPadding)
        ) {
            val checkedState = remember { mutableStateOf(true) }
            Column {
                MainPrimaryText(
                    text = composableString(SharedRes.strings.app_name)
                )
                MainButton(text = "Click",onClick = {},outlined = false)
                SvgImage(
                    res = SharedRes.images.launch_success
                )

                CrossLoadingWheel(contentDesc = "test")

                MainSwitch(checkedState.value, {
                    checkedState.value = it
                },)
            }
        }
    }
}