package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.coilVersion
import extensions.dependency

public class CoilDependencies {
    public val compose: String by lazy {
        dependency(
            groupWithArtifact = "io.coil-kt.coil3:coil-compose",
            version = coilVersion
        )
    }

    public val core: String by lazy {
        dependency(
            groupWithArtifact = "io.coil-kt.coil3:coil-compose-core",
            version = coilVersion
        )
    }

    public val coilKtor: String by lazy {
        dependency(
            groupWithArtifact = "io.coil-kt.coil3:coil-network-ktor",
            version = coilVersion
        )
    }

    public val coilMp: String by lazy {
        dependency(
            groupWithArtifact = "io.coil-kt.coil3:coil",
            version = coilVersion
        )
    }

    public fun configureDependencies(
        extension: KotlinMultiplatformExtension
    ): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(core)
                implementation(compose)
                implementation(coilKtor)
                implementation(coilMp)
            }
        }
    }
}