import android.os.Build

class AndroidComposePlatform : ComposePlatform {
    override val type: ComposePlatformType = ComposePlatformType.ANDROID

    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): ComposePlatform = AndroidComposePlatform()


