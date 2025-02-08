package dependencies

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions.roomVersion
import versions.Versions.sqliteVersion
import extensions.dependency

public class RoomDependencies {
    private val kspConfigurations = listOf(
        "kspAndroid",
        "kspIosSimulatorArm64",
        "kspIosX64",
        "kspIosArm64"
    )

    public val roomCompiler: String by lazy {
        dependency(
            groupWithArtifact = "androidx.room:room-compiler",
            version = roomVersion
        )
    }

    public val roomRuntime: String by lazy {
        dependency(groupWithArtifact = "androidx.room:room-runtime", version = roomVersion)
    }

    public val roomPaging: String by lazy {
        dependency(groupWithArtifact = "androidx.room:room-paging", version = roomVersion)
    }

    public val sqliteBundled: String by lazy {
        dependency(groupWithArtifact = "androidx.sqlite:sqlite-bundled", version = sqliteVersion)
    }

    public val sqlite: String by lazy {
        dependency(groupWithArtifact = "androidx.sqlite:sqlite", version = sqliteVersion)
    }

    public fun configureDependencies(
        extension: KotlinMultiplatformExtension
    ): KotlinMultiplatformExtension = extension.apply {
        project.dependencies.apply {
            kspConfigurations.forEach { add(it, roomCompiler) }
        }
        with(sourceSets) {
            commonMain.dependencies {
                implementation(roomRuntime)
                implementation(sqliteBundled)
                implementation(sqlite)
            }

            androidMain.dependencies {
                implementation(roomPaging)
            }
        }
    }
}
