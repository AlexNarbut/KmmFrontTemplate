package ru.narbut.kmmfronttemp.presentation.theme

import dev.icerock.moko.resources.StringResource

expect class Strings {
    fun get(id : StringResource, args: List<Any> = emptyList()) : String
}