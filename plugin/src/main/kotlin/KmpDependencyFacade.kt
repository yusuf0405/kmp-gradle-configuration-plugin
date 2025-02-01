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
import factories.ConfigurationExtensionFactory
import factories.DependencyFactory
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal class KmpDependencyFacade(
    private val factory: DependencyFactory,
    private val extensionFactory: ConfigurationExtensionFactory,
) {
    val coroutine: CoroutineDependencies by lazy { factory.createMultiplatformDependencies() }
    val compose: ComposeDependencies by lazy { factory.createComposeDependencies() }
    val koin: KoinDependencies by lazy { factory.createKoinDependencies() }
    val ktor: KtorDependencies by lazy { factory.createKtorDependencies() }
    val room: RoomDependencies by lazy { factory.createRoomDependencies() }
    val dataStore: DataStoreDependencies by lazy { factory.createDataStoreDependencies() }
    val lifecycle: LifecycleDependencies by lazy { factory.createLifecycleDependencies() }
    val coil: CoilDependencies by lazy { factory.createCoilDependencies() }
    val kotlinX: KotlinXDependencies by lazy { factory.createKotlinXDependencies() }

    val kotlinMultiplatformExtension: KotlinMultiplatformExtension by lazy {
        extensionFactory.multiplatformExtension
    }

    val composeExtension: ComposeExtension by lazy {
        extensionFactory.composeExtension
    }

    val applicationConfigurator: AndroidApplicationConfigurator by lazy {
        AndroidApplicationConfigurator(extensionFactory.applicationExtension)
    }

    val libraryConfigurator: AndroidLibraryConfigurator by lazy {
        AndroidLibraryConfigurator(
            multiplatformExtension = extensionFactory.multiplatformExtension,
            libraryExtension = extensionFactory.libraryExtension
        )
    }
}