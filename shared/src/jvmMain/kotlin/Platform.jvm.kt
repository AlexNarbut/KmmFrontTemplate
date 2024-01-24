class JVMComposePlatform: ComposePlatform {
    override val type: ComposePlatformType = ComposePlatformType.DESKTOP
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): ComposePlatform = JVMComposePlatform()