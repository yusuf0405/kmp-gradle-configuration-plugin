package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.dataStoreVersion
import extensions.dependency

public class DataStoreDependencies(
    private val extension: KotlinMultiplatformExtension
) {
    public val core: String by lazy {
        dependency(
            groupWithArtifact = "androidx.datastore:datastore-core-okio",
            version = dataStoreVersion
        )
    }
    public val preferences: String by lazy {
        dependency(
            groupWithArtifact = "androidx.datastore:datastore-preferences-core",
            version = dataStoreVersion
        )
    }

    public fun configureDependencies(): KotlinMultiplatformExtension = extension.apply {
        sourceSets.apply {
            commonMain.dependencies {
                api(preferences)
                api(core)
            }
        }
    }
}