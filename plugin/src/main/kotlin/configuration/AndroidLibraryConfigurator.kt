package configuration

import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions

public class AndroidLibraryConfigurator(
    private val multiplatformExtension: KotlinMultiplatformExtension,
    private val libraryExtension: LibraryExtension,
) {
    public fun configureLibraryCompose(): LibraryExtension = libraryExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
        }
    }

    public fun configureAndroidLibrary(androidNamespace: String): LibraryExtension =
        libraryExtension.apply {
            namespace = androidNamespace
            compileSdk = Versions.androidCompileSdk

            defaultConfig {
                minSdk = Versions.androidMinSdk
            }

            compileOptions {
                sourceCompatibility = Versions.javaVersion
                targetCompatibility = Versions.javaVersion
            }
        }

    public fun configureKotlinMultiplatform(): KotlinMultiplatformExtension {
        return multiplatformExtension.apply {
            jvmToolchain(Versions.jvmTarget)
            androidTarget()
            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            )
        }
    }
}