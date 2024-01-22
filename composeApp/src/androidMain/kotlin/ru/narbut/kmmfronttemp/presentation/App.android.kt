package ru.narbut.kmmfronttemp.presentation

import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.retainedComponent
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.narbut.kmmfronttemp.App
import ru.narbut.kmmfronttemp.di.KoinModules
import ru.narbut.kmmfronttemp.presentation.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.presentation.theme.AppContext
import ru.narbut.kmmfronttemp.presentation.theme.DEFAULT_APP_DIMENS
import ru.narbut.kmmfronttemp.presentation.theme.initContext

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AndroidApp)
            modules(KoinModules.AppModules)
        }
        INSTANCE = this
    }
}

class AppActivity : FragmentActivity() {

    @OptIn(ExperimentalDecomposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val root = retainedComponent {
            RootComponentChildStack(it)
        }

        initContext(
            MutableStateFlow(
                AppContext(
                    context = this.applicationContext,
                    DEFAULT_APP_DIMENS.getDimensClass()
                )
            )
        )

        setContent {
            App(root)
        }
    }
}