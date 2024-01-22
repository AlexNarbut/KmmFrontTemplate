package ru.narbut.kmmfronttemp.presentation.theme

import android.content.Context
import dev.icerock.moko.resources.StringResource

actual class AppContext(context: Context, private val dimensImpl: DimensImpl) {
    private val strings = Strings(context)

    actual val dimens: DimensImpl get() = dimensImpl

    actual fun getString(resId: StringResource): String {
        return strings.get(resId)
    }

    actual fun getString(resId: StringResource, vararg formatArgs: Any): String {
        return strings.get(resId,formatArgs.toList())
    }
}
