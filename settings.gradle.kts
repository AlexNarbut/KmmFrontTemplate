rootProject.name = "KmmFrontTemp"
include(":composeApp")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

include(":shared")
