package ru.narbut.kmmfronttemp.presentation.navigation.component

import kotlinx.coroutines.CoroutineExceptionHandler

object GlobalErrorHandler {
    var globalErrorHandler = CoroutineExceptionHandler { _, exception ->
        println(exception)
        println(exception.stackTraceToString())
    }
}