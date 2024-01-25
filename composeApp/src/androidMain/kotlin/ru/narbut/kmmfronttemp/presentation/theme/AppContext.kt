package ru.narbut.kmmfronttemp.presentation.theme

import android.content.Context

actual class AppContext(context: Context, private val dimensImpl: DimensImpl) {
    actual val dimens: DimensImpl get() = dimensImpl
}
