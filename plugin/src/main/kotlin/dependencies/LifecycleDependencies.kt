package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.lifecycleVersion
import extensions.dependency

public class LifecycleDependencies {
    public val viewModel: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose",
            version = lifecycleVersion
        )
    }

    public val runtime: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose",
            version = lifecycleVersion
        )
    }

    public fun configureDependencies(
        extension: KotlinMultiplatformExtension
    ): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                implementation(viewModel)
                implementation(runtime)
            }
        }
    }
}