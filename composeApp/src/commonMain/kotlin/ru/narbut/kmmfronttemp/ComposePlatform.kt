package ru.narbut.kmmfronttemp

enum class ComposePlatform {
    ANDROID, IOS, DESKTOP
}

expect fun getComposePlatform() : ComposePlatform