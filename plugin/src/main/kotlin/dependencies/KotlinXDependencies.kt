package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.kotlinxDatetimeVersion
import versions.Versions.kotlinxSerializationVersion
import extensions.dependency

public class KotlinXDependencies(
    private val extension: KotlinMultiplatformExtension
) {
    public val kotlinxSerialization: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-serialization-json",
            version = kotlinxSerializationVersion
        )
    }

    public val kotlinxDatetime: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.kotlinx:kotlinx-datetime",
            version = kotlinxDatetimeVersion
        )
    }

    public fun configureDependencies(): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(kotlinxSerialization)
                implementation(kotlinxDatetime)
            }
        }
    }
}