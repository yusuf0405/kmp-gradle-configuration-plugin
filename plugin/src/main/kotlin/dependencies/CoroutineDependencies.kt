package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.coroutineVersion
import extensions.dependency

public class CoroutineDependencies(
    private val extension: KotlinMultiplatformExtension
) {
    public val core: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-coroutines-core",
            version = coroutineVersion
        )
    }

    public val android: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-coroutines-android",
            version = coroutineVersion
        )
    }

    public val swing: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-coroutines-swing",
            version = coroutineVersion
        )
    }

    public val test: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-coroutines-test",
            version = coroutineVersion
        )
    }

    public fun configureDependencies(): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(core)
            }
            commonTest.dependencies {
                implementation(test)
            }

            androidMain.dependencies {
                implementation(android)
            }
            jvmMain.dependencies {
                implementation(swing)
            }
        }
    }
}