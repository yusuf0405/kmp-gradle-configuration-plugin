import configurations.AndroidApplicationConfigurator
import configurations.AndroidLibraryConfigurator
import dependencies.CoilDependencies
import dependencies.ComposeDependencies
import dependencies.CoroutineDependencies
import dependencies.DataStoreDependencies
import dependencies.KoinDependencies
import dependencies.KotlinXDependencies
import dependencies.KtorDependencies
import dependencies.LifecycleDependencies
import dependencies.RoomDependencies
import di.Injector
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import versions.Versions

public abstract class KmpConfigurationExtension : ExtensionAware {

    private val facade: KmpDependencyFacade by lazy { Injector.facade }

    public val versions: Versions by lazy { Versions }
    public val coroutine: CoroutineDependencies by lazy { facade.coroutine }
    public val compose: ComposeDependencies by lazy { facade.compose }
    public val koin: KoinDependencies by lazy { facade.koin }
    public val ktor: KtorDependencies by lazy { facade.ktor }
    public val room: RoomDependencies by lazy { facade.room }
    public val dataStore: DataStoreDependencies by lazy { facade.dataStore }
    public val lifecycle: LifecycleDependencies by lazy { facade.lifecycle }
    public val coil: CoilDependencies by lazy { facade.coil }
    public val kotlinX: KotlinXDependencies by lazy { facade.kotlinX }

    public val kotlinMultiplatformExtension: KotlinMultiplatformExtension by lazy {
        facade.kotlinMultiplatformExtension
    }

    public val composeExtension: ComposeExtension by lazy {
        facade.composeExtension
    }

    public val applicationConfigurator: AndroidApplicationConfigurator by lazy {
        facade.applicationConfigurator
    }

    public val libraryConfigurator: AndroidLibraryConfigurator by lazy {
        facade.libraryConfigurator
    }
}