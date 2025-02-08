import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * KmpConfigurationPlugin is a Gradle plugin that configures Kotlin Multiplatform
 * projects with support for Android and Compose based on the project type.
 * It applies the necessary configurations depending on whether the project is
 * an Android application or Android library.
 */
public class KmpConfigurationPlugin : Plugin<Project> {

    private companion object {
        private const val EXTENSION_NAME = "kmpConfiguration"
    }

    /**
     * The apply method is called when the plugin is applied to a Gradle project.
     * It creates an extension for configuring the project, applies Kotlin Multiplatform plugin,
     * and applies configuration for Android applications or libraries.
     *
     * @param target The Gradle project to which the plugin is applied.
     */
    override fun apply(target: Project): Unit = with(target) {
        val extension = extensions.create(
            EXTENSION_NAME,
            KmpConfigurationExtension::class.java
        )

        applyKotlinMultiplatform()
        println("Applying configurations for project: ${target.name}")
        when {
            isAndroidApplication() -> {
                println("Configuring as Android Application")
                configureAndroidApp(extension)
            }

            isAndroidLibrary() -> {
                println("Configuring as Android Library")
                configureAndroidLibrary(extension)
            }

            else -> {
                println("Project type is not recognized. No configurations applied.")
            }
        }
    }

    /**
     * Configures the project as an Android application by applying the necessary
     * configurations to the Android Application Extension.
     *
     * @param extension The plugin's extension to be used for configuration.
     */
    private fun Project.configureAndroidApp(extension: KmpConfigurationExtension) {
        println("Configuring Android Application using ApplicationExtension.")
        extensions.configure(ApplicationExtension::class.java) {
            extension.applicationConfigurator.configure(it)
        }
    }

    /**
     * Configures the project as an Android library by applying the necessary
     * configurations to both the Android Library Extension and the Kotlin Multiplatform Extension.
     * Additionally, if Compose Multiplatform is used, it configures the library with Compose support.
     *
     * @param extension The plugin's extension to be used for configuration.
     */
    private fun Project.configureAndroidLibrary(extension: KmpConfigurationExtension) {
        println("Configuring Android Library using LibraryExtension.")
        extensions.apply {
            configure(LibraryExtension::class.java) {
                extension.libraryConfigurator.configureAndroidLibrary(it)
                if (isComposeMultiplatform()) {
                    println("Configuring Compose support for Android Library.")
                    extension.libraryConfigurator.configureLibraryCompose(it)
                }
            }

            configure(KotlinMultiplatformExtension::class.java) {
                println("Configuring KMP source sets for Android Library.")
                extension.libraryConfigurator.configureKotlinMultiplatform(it)
            }
        }
    }

    /**
     * Applies the Kotlin Multiplatform plugin to the project if it's not already applied.
     */
    private fun Project.applyKotlinMultiplatform() {
        println("Applying Kotlin Multiplatform plugin.")
        if (!plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) {
            plugins.apply("org.jetbrains.kotlin.multiplatform")
        }
    }

    /**
     * Checks if the project is an Android application by verifying the presence of the 'com.android.application' plugin.
     *
     * @return true if the project is an Android application, false otherwise.
     */
    private fun Project.isAndroidApplication(): Boolean =
        plugins.hasPlugin("com.android.application")

    /**
     * Checks if the project is an Android library by verifying the presence of the 'com.android.library' plugin.
     *
     * @return true if the project is an Android library, false otherwise.
     */
    private fun Project.isAndroidLibrary(): Boolean = plugins.hasPlugin("com.android.library")

    /**
     * Checks if the project uses Compose Multiplatform by verifying the presence of the 'org.jetbrains.compose' plugin.
     *
     * @return true if Compose Multiplatform is used, false otherwise.
     */
    private fun Project.isComposeMultiplatform(): Boolean =
        plugins.hasPlugin("org.jetbrains.compose")
}