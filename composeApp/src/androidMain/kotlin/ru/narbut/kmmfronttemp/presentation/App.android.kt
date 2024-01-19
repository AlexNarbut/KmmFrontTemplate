package ru.narbut.kmmfronttemp.presentation

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.retainedComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.narbut.kmmfronttemp.presentation.app.AppUI
import ru.narbut.kmmfronttemp.presentation.app.root.RootComponentChildStack
import ru.narbut.kmmfronttemp.di.KoinModules
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

        initContext(AppUI.appContext)

        setContent {
            App(root)
        }
    }
}


internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}