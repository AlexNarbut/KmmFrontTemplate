import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.coroutines.flow.MutableStateFlow
import platform.UIKit.UIViewController
import ru.narbut.kmmfronttemp.App
import ru.narbut.kmmfronttemp.presentation.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.presentation.theme.AppContext
import ru.narbut.kmmfronttemp.presentation.theme.DEFAULT_APP_DIMENS
import ru.narbut.kmmfronttemp.presentation.theme.initContext

fun MainViewController(root: RootComponentChildStack): UIViewController = ComposeUIViewController {
    initContext(
        MutableStateFlow(
            AppContext(
                DEFAULT_APP_DIMENS.getDimensClass()
            )
        )
    )
    App(component = root)
}
