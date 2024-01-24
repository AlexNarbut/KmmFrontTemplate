import platform.UIKit.UIDevice

class IOSComposePlatform: ComposePlatform {
    override val type: ComposePlatformType = ComposePlatformType.IOS
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): ComposePlatform = IOSComposePlatform()