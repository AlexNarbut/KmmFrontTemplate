package ru.narbut.kmmfronttemp.navigation.component


sealed class LCEState<out T> {
    class None : LCEState<Nothing>()
    class Loading : LCEState<Nothing>()
    class Content<T>(val content: T) : LCEState<T>()
    class Error(val error: String) : LCEState<Nothing>()

    companion object {
        val None = None()
        val Loading = Loading()
    }
}

fun <T, R> LCEState<T>.mapContent(mapper: (T) -> R): LCEState<R> {
    return when (this) {
        is LCEState.Content -> LCEState.Content(mapper(content))
        is LCEState.Error -> this
        is LCEState.Loading -> this
        is LCEState.None -> this
    }
}

inline fun <T> LCEState<T>.content(action: (T) -> Unit) {
    if (this is LCEState.Content) action(content)
}

val <T> LCEState<T>.content: T?
    get() = if (this is LCEState.Content) content else null


