package ru.narbut.kmmfronttemp.config

import org.jetbrains.skiko.GpuPriority
import java.io.File

object GraphicsConfig {
    private const val RESOURCES_PROPERTY_NAME = "compose.application.resources.dir"
    private const val CONFIG_FILE = "graphics.settings"
    private const val RENDER_API = "renderApi"
    private const val GPU_PRIORITY = "gpuPriority"
    private const val defaultApi = "OPENGL"
    private val defaultGpuPriority = GpuPriority.Auto


    fun initGraphics() {
//        if (OperationSystemUtils.getOperationInfo().deviceType == DeviceType.WINDOWS) {
//            val properties = readProperties(CONFIG_FILE)
//            Log.d { "$properties" }
//            val api = parseRenderApi(properties?.get(RENDER_API))
//            val gpuPriority = parseGpuPriority(properties?.get(GPU_PRIORITY))
//
//            System.setProperty("skiko.renderApi", api)
//
//            if (gpuPriority != defaultGpuPriority) {
//                System.setProperty("skiko.directx.gpu.priority", gpuPriority.value)
//            }
//        }
    }

    fun getGraphicsConfigFile(): File? {
        val resourcesDir = System.getProperty(RESOURCES_PROPERTY_NAME)?.let { File(it) }
        return resourcesDir?.resolve(CONFIG_FILE) ?: return null
    }

//    fun applyFrom(file: File) {
//        val resourcesDir = System.getProperty(RESOURCES_PROPERTY_NAME)?.let { File(it) }
//        val userProperties = readProperties(file.path) ?: return
//        val appProperties = readProperties(CONFIG_FILE)
//
//        val resultProperties = replaceProperties(appProperties ?: emptyMap(), userProperties)
//        val graphicsFile = getGraphicsConfigFile() ?: return
//        writeProperties(resultProperties, graphicsFile)
//    }
//
//    private fun readProperties(path: String): Map<String, String>? {
//        val resourcesDir = System.getProperty(RESOURCES_PROPERTY_NAME)?.let { File(it) }
//        val resource = safeRun { resourcesDir?.resolve(path)?.readText() }.getValueIfSuccess() ?: return null
//        val list = resource.split("\n").map { it.replace("""\s""".toRegex(), "") }
//
//
//        return mapOf(
//            *list.mapNotNull { item ->
//                val split = item.split("=")
//                if (split.size != 2) return@mapNotNull null
//                else Pair(split[0], split[1])
//            }.toTypedArray()
//        )
//    }

    private fun replaceProperties(source: Map<String, String>, replaceWith: Map<String, String>): Map<String, String> {
        val result = source.toMutableMap()

        for (property in replaceWith) {
            result[property.key] = property.value
        }

        return result
    }

    private fun writeProperties(properties: Map<String, String>, toFile: File) {
        val sb = StringBuilder()
        for (property in properties) {
            sb.appendLine("${property.key}=${property.value}")
        }

        toFile.writeText(sb.toString())

    }


    private fun parseRenderApi(text: String?): String {
        return when (text?.uppercase()) {
            "SOFTWARE_COMPAT" -> "SOFTWARE_COMPAT"
            "SOFTWARE_FAST", "DIRECT_SOFTWARE", "SOFTWARE" -> "SOFTWARE_FAST"
            "OPENGL" -> "OPENGL"
            "DIRECT3D" -> "DIRECT3D"
            else -> defaultApi
        }
    }

    private fun parseGpuPriority(text: String?): GpuPriority {
        return when (text?.uppercase()) {
            "AUTO" -> GpuPriority.Auto
            "INTEGRATED" -> GpuPriority.Integrated
            "DISCRETE" -> GpuPriority.Discrete
            else -> defaultGpuPriority
        }
    }
}