package ru.narbut.kmmfronttemp.presentation.app

import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

object AppUI {
    fun<C: Any, T: Any> defaultStackTransitionAnimation(): StackAnimation<C, T> = stackAnimation(fade())
}