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
import factories.DependencyFactory

internal class KmpDependencyFacade(private val factory: DependencyFactory) {
    val coroutine: CoroutineDependencies by lazy { factory.createCoroutineDependencies() }
    val compose: ComposeDependencies by lazy { factory.createComposeDependencies() }
    val koin: KoinDependencies by lazy { factory.createKoinDependencies() }
    val ktor: KtorDependencies by lazy { factory.createKtorDependencies() }
    val room: RoomDependencies by lazy { factory.createRoomDependencies() }
    val dataStore: DataStoreDependencies by lazy { factory.createDataStoreDependencies() }
    val lifecycle: LifecycleDependencies by lazy { factory.createLifecycleDependencies() }
    val coil: CoilDependencies by lazy { factory.createCoilDependencies() }
    val kotlinX: KotlinXDependencies by lazy { factory.createKotlinXDependencies() }

    val applicationConfigurator: AndroidApplicationConfigurator by lazy { AndroidApplicationConfigurator() }
    val libraryConfigurator: AndroidLibraryConfigurator by lazy { AndroidLibraryConfigurator() }
}