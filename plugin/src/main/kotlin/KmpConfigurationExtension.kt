import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import configuration.AndroidApplicationConfigurator
import configuration.AndroidLibraryConfigurator
import dependencies.ComposeDependencies
import dependencies.CoroutineDependencies
import dependencies.DataStoreDependencies
import dependencies.LifecycleDependencies
import dependencies.KoinDependencies
import dependencies.KtorDependencies
import dependencies.RoomDependencies
import dependencies.CoilDependencies
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions
import javax.inject.Inject

public abstract class KmpConfigurationExtension @Inject constructor(
    private val project: Project
) : ExtensionAware {

    public val multiplatformExtension: KotlinMultiplatformExtension?
        get() {
            return project.extensions.findByType(KotlinMultiplatformExtension::class.java)
        }

    public val composeExtension: ComposeExtension?
        get() {
            return project.extensions.findByType(ComposeExtension::class.java)
        }

    private val applicationExtension: ApplicationExtension?
        get() {
            return project.extensions.findByType(ApplicationExtension::class.java)
        }

    private val libraryExtension: LibraryExtension?
        get() {
            return project.extensions.findByType(LibraryExtension::class.java)
        }

    public val versions: Versions by lazy { Versions }

    public val coroutine: CoroutineDependencies by lazy {
        CoroutineDependencies(requireMultiplatformExtension())
    }

    public val compose: ComposeDependencies by lazy {
        ComposeDependencies(
            composeExtension = requireComposeExtension(),
            extension = requireMultiplatformExtension()
        )
    }

    public val koin: KoinDependencies by lazy {
        KoinDependencies(requireMultiplatformExtension())
    }

    public val ktor: KtorDependencies by lazy {
        KtorDependencies(requireMultiplatformExtension())
    }

    public val room: RoomDependencies by lazy {
        RoomDependencies(requireMultiplatformExtension())
    }

    public val dataStore: DataStoreDependencies by lazy {
        DataStoreDependencies(requireMultiplatformExtension())
    }

    public val lifecycle: LifecycleDependencies by lazy {
        LifecycleDependencies(requireMultiplatformExtension())
    }

    public val coil: CoilDependencies by lazy {
        CoilDependencies(requireMultiplatformExtension())
    }

    public val applicationConfigurator: AndroidApplicationConfigurator by lazy {
        AndroidApplicationConfigurator(requireApplicationExtension())
    }

    public val libraryConfigurator: AndroidLibraryConfigurator by lazy {
        AndroidLibraryConfigurator(
            libraryExtension = requireLibraryExtension(),
            multiplatformExtension = requireMultiplatformExtension()
        )
    }

    private fun requireMultiplatformExtension(): KotlinMultiplatformExtension {
        return checkNotNull(multiplatformExtension) { "Multiplatform extension not set" }
    }

    private fun requireComposeExtension(): ComposeExtension {
        return checkNotNull(composeExtension) { "Compose extension not set" }
    }

    private fun requireApplicationExtension(): ApplicationExtension {
        return checkNotNull(applicationExtension) { "Android application extension not set" }
    }

    private fun requireLibraryExtension(): LibraryExtension {
        return checkNotNull(libraryExtension) { "Android library extension not set" }
    }
}