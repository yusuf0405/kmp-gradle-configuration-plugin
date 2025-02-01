package factories

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal interface ConfigurationExtensionFactory {
    val multiplatformExtension: KotlinMultiplatformExtension
    val composeExtension: ComposeExtension
    val applicationExtension: ApplicationExtension
    val libraryExtension: LibraryExtension

    class Default(private val project: Project) : ConfigurationExtensionFactory {

        override val multiplatformExtension: KotlinMultiplatformExtension
            get() {
                return checkNotNull(findByType(KotlinMultiplatformExtension::class.java)) {
                    "Multiplatform extension not set"
                }
            }

        override val composeExtension: ComposeExtension
            get() {
                return checkNotNull(findByType(ComposeExtension::class.java)) {
                    "Compose extension not set"
                }
            }

        override val applicationExtension: ApplicationExtension
            get() {
                return checkNotNull(findByType(ApplicationExtension::class.java)) {
                    "Android application extension not set"
                }
            }

        override val libraryExtension: LibraryExtension
            get() {
                return checkNotNull(findByType(LibraryExtension::class.java)) {
                    "Android library extension not set"
                }
            }

        private fun <T> findByType(type: Class<T>) = project.extensions.findByType(type)
    }
}