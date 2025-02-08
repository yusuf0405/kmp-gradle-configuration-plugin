package dependencies

import extensions.dependency
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions

public class ComposeDependencies {
    public val navigation: String by lazy {
        dependency(
            groupWithArtifact = "org.jetbrains.androidx.navigation:navigation-compose",
            version = Versions.navigationCompose
        )
    }

    public fun configureDependencies(
        extension: KotlinMultiplatformExtension,
        composeDependencies: ComposePlugin.Dependencies
    ): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain {
                dependencies {
                    api(composeDependencies.components.resources)
                    implementation(composeDependencies.ui)
                    implementation(composeDependencies.foundation)
                    implementation(composeDependencies.runtime)
                    implementation(composeDependencies.animation)
                    implementation(composeDependencies.animationGraphics)
                    implementation(composeDependencies.material3)
                    implementation(composeDependencies.materialIconsExtended)
                    implementation(composeDependencies.components.uiToolingPreview)
                    implementation(navigation)
                }
            }

            jvmMain.dependencies {
                implementation(composeDependencies.desktop.currentOs)
            }

            androidMain.dependencies {
                implementation(composeDependencies.uiTooling)
            }

            commonTest.dependencies {
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(composeDependencies.uiTest)
            }
        }
    }
}