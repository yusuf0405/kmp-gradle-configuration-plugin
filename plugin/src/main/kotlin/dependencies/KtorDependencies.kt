package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.ktorVersion
import extensions.dependency

public class KtorDependencies {
    public val core: String by lazy {
        dependency(
            groupWithArtifact = "io.ktor:ktor-client-core",
            version = ktorVersion
        )
    }
    public val logging: String by lazy {
        dependency(
            groupWithArtifact = "io.ktor:ktor-client-logging",
            version = ktorVersion
        )
    }

    public val contentNegotiation: String = dependency(
        groupWithArtifact = "io.ktor:ktor-client-content-negotiation",
        version = ktorVersion
    )

    public val serialization: String by lazy {
        dependency(
            groupWithArtifact = "io.ktor:ktor-serialization-kotlinx-json",
            version = ktorVersion
        )
    }

    public val ktorClientDarwin: String by lazy {
        dependency(
            groupWithArtifact = "io.ktor:ktor-client-darwin",
            version = ktorVersion
        )
    }

    public val ktorClientAndroid: String by lazy {
        dependency(
            groupWithArtifact = "io.ktor:ktor-client-android",
            version = ktorVersion
        )
    }

    public fun configureDependencies(
        extension: KotlinMultiplatformExtension
    ): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(core)
                implementation(logging)
                implementation(serialization)
                implementation(contentNegotiation)
            }

            androidMain.dependencies {
                implementation(ktorClientAndroid)
            }
            iosMain.dependencies {
                implementation(ktorClientDarwin)
            }
        }
    }
}