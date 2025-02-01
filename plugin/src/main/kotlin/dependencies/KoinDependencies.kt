package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.koinVersion
import extensions.dependency

public class KoinDependencies(
    private val extension: KotlinMultiplatformExtension
) {
    public val core: String by lazy {
        dependency(
            groupWithArtifact = "io.insert-koin:koin-core",
            version = koinVersion
        )
    }

    public val test: String by lazy {
        dependency(
            groupWithArtifact = "io.insert-koin:koin-test",
            version = koinVersion
        )
    }

    public val android: String by lazy {
        dependency(
            groupWithArtifact = "io.insert-koin:koin-android",
            version = koinVersion
        )
    }

    public val compose: String by lazy {
        dependency(
            groupWithArtifact = "io.insert-koin:koin-compose",
            version = koinVersion
        )
    }

    public fun configureDependencies(): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(core)
                implementation(compose)
            }

            androidMain.dependencies {
                implementation(android)
            }
        }
    }
}