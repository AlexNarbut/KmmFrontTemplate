plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
}


buildscript {
    repositories {
        gradlePluginPortal()
        mavenLocal()
    }

    dependencies {
        val mokoResourceVersion = libs.versions.moko.resources.get()
        classpath("dev.icerock.moko:resources-generator:$mokoResourceVersion")
    }
}


