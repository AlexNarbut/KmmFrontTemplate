import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import platform.UIKit.UIViewController
import ru.narbut.kmmfronttemp.App
import ru.narbut.kmmfronttemp.app.AppUI
import ru.narbut.kmmfronttemp.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.theme.initContext

fun MainViewController(): UIViewController = ComposeUIViewController {
    initContext(AppUI.appContext)
    val root = remember {
        RootComponentChildStack(DefaultComponentContext(LifecycleRegistry()))
    }
    App(root)
}
