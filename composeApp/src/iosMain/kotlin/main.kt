import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.narbut.kmmfronttemp.App
import ru.narbut.kmmfronttemp.presentation.app.AppUI
import ru.narbut.kmmfronttemp.presentation.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.presentation.theme.initContext

fun MainViewController(root: RootComponentChildStack): UIViewController = ComposeUIViewController {
    initContext(AppUI.appContext)
    App(component = root)
}
