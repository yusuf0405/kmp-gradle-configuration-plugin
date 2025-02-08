package configurations

import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions

public class AndroidLibraryConfigurator {

    internal fun configureAndroidLibrary(
        extension: LibraryExtension,
    ): LibraryExtension = extension.apply {
        compileSdk = Versions.androidCompileSdk

        defaultConfig {
            minSdk = Versions.androidMinSdk
        }

        compileOptions {
            sourceCompatibility = Versions.javaVersion
            targetCompatibility = Versions.javaVersion
        }
    }

    internal fun configureLibraryCompose(
        extension: LibraryExtension
    ): LibraryExtension = extension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
        }
    }

    internal fun configureKotlinMultiplatform(
        multiplatformExtension: KotlinMultiplatformExtension
    ): KotlinMultiplatformExtension = multiplatformExtension.apply {
        jvmToolchain(Versions.jvmTarget)
        jvm()
        wasmJs()
        androidTarget()
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        )
    }
}