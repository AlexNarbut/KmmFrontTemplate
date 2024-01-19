package ru.narbut.kmmfronttemp.presentation

import org.koin.core.context.startKoin
import ru.narbut.kmmfronttemp.di.KoinModules

fun doInitKoin() {
    startKoin {
        modules(KoinModules.AppModules)
    }
}