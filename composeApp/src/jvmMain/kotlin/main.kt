import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.context.startKoin
import ru.narbut.kmmfronttemp.app.AppUI
import ru.narbut.kmmfronttemp.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.config.GraphicsConfig
import ru.narbut.kmmfronttemp.di.KoinModules
import ru.narbut.kmmfronttemp.navigation.component.UIComponent
import ru.narbut.kmmfronttemp.theme.composableDimens
import ru.narbut.kmmfronttemp.theme.initContext
import kotlin.system.exitProcess

fun main() {
    startKoin {
        modules(KoinModules.AppModules)
    }
    GraphicsConfig.initGraphics()

    val lifecycle = LifecycleRegistry()
    val rootComponent = RootComponentChildStack(DefaultComponentContext(lifecycle))
    initContext(AppUI.appContext)

    startApplication(rootComponent, lifecycle)
}

@OptIn(ExperimentalDecomposeApi::class)
private fun startApplication(rootComponent: UIComponent, lifecycle: LifecycleRegistry) {
    application {
        val isOpen = remember { mutableStateOf(true) }
        //val windowIcon = painterResource(Images.drawables.logo_png)
        val isVisible = remember { mutableStateOf(true) }
        val windowState = rememberWindowState(
            width = composableDimens().windowWidth.dp,
            height = composableDimens().windowHeight.dp,
            placement = WindowPlacement.Floating
        )
        LifecycleController(lifecycle, windowState)

        if (isOpen.value) {
            // Required to make sure the JavaFx event loop doesn't finish
            // (can happen when java fx panels in app are shown/hidden)
//            val finishListener = object : PlatformImpl.FinishListener {
//                override fun idle(implicitExit: Boolean) {}
//                override fun exitCalled() {}
//            }
//            PlatformImpl.addListener(finishListener)

            Window(
                onCloseRequest = {
                    //PlatformImpl.addListener(finishListener)
                    isOpen.value = false
                },
                visible = isVisible.value,
                title = "Kmp app",
                state = windowState,
                undecorated = false,
                resizable = true
            ) {
                rootComponent.render()
//                SpecTray(
//                    windowIcon = windowIcon,
//                    isAppVisible = isVisible,
//                    onCloseClick = { isOpen.value = false }
//                )
            }
        } else {
            exitApplication()
            exitProcess(0)
        }
    }
}

@Composable
private fun ApplicationScope.SpecTray(
    windowIcon: Painter,
    isAppVisible: MutableState<Boolean>,
    onCloseClick: () -> Unit,

    ) {
    val trayState = rememberTrayState()
    Tray(
        icon = windowIcon,
        state = trayState,
        menu = {
            if (!isAppVisible.value) {
                Item("Show", onClick = { isAppVisible.value = true })
            } else {
                Item("Hide", onClick = { isAppVisible.value = false })
            }
            Item("Exit", onClick = onCloseClick)
        }
    )
}