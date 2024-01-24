interface ComposePlatform {
    val type : ComposePlatformType
    val name: String
}

enum class ComposePlatformType {
    ANDROID, IOS, DESKTOP;

    fun isAndroid() = this == ANDROID
    fun isIOS() = this == IOS
    fun isDesktop() = this == DESKTOP
}

expect fun getPlatform(): ComposePlatform

fun getPlatformType() = getPlatform().type