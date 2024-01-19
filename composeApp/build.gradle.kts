import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    //alias(libs.plugins.cocoapods)
    alias(libs.plugins.android.application)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true

            transitiveExport = true

            export(libs.decompose)
            export(libs.essenty)
        }
    }

//    cocoapods {
//        version = "1.0.0"
//        summary = "Compose application framework"
//        homepage = "empty"
//        ios.deploymentTarget = "15.6"
//        podfile = project.file("../iosApp/Podfile")
//        framework {
//            baseName = "ComposeApp"
//
//            export(libs.decompose)
//            export(libs.kmm.essenty)
//        }
//        //extraSpecAttributes["resources"] = "['src/commonMain/resources/**']"
//    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation(libs.koin)
                implementation(libs.koin.compose)

                api(libs.decompose)
                api(libs.decompose.compose)
                api(libs.essenty)


                implementation(libs.composeImageLoader)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }


        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activityCompose)
                implementation(libs.compose.uitooling)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.accompanist.systemui)

                implementation(libs.decompose.compose.jetbrains)

                implementation(libs.koin.android)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(compose.desktop.currentOs)

                implementation(libs.decompose.compose.jetbrains)

                implementation(libs.kotlinx.coroutines.swing)
            }
        }

        val iosX64Main by getting {
            //resources.srcDirs("build/generated/moko/iosX64Main/src")
        }
        val iosArm64Main by getting {
            //resources.srcDirs("build/generated/moko/iosArm64Main/src")
        }
        val iosSimulatorArm64Main by getting {
            //resources.srcDirs("build/generated/moko/iosSimulatorArm64Main/src")
        }
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {

            }
        }

//        iosMain.dependencies {
//
//        }
    }

}

android {
    namespace = "ru.narbut.kmmfronttemp"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        applicationId = "ru.narbut.kmmfronttemp.androidApp"
        versionCode = 1
        versionName = "1.0.0"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
        resources.srcDirs("src/commonMain/resources")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ru.narbut.kmmfronttemp.desktopApp"
            packageVersion = "1.0.0"
        }
    }
}

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
}
