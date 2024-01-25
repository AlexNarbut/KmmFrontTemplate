package ru.narbut.kmmfronttemp.presentation.theme

actual class AppContext(private val dimensImpl: DimensImpl) {
    actual val dimens: DimensImpl get() = dimensImpl
}
