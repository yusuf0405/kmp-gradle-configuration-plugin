package factories

import dependencies.CoilDependencies
import dependencies.ComposeDependencies
import dependencies.CoroutineDependencies
import dependencies.DataStoreDependencies
import dependencies.KoinDependencies
import dependencies.KotlinXDependencies
import dependencies.KtorDependencies
import dependencies.LifecycleDependencies
import dependencies.RoomDependencies
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal interface DependencyFactory {
    fun createMultiplatformDependencies(): CoroutineDependencies
    fun createComposeDependencies(): ComposeDependencies
    fun createKoinDependencies(): KoinDependencies
    fun createKtorDependencies(): KtorDependencies
    fun createRoomDependencies(): RoomDependencies
    fun createDataStoreDependencies(): DataStoreDependencies
    fun createLifecycleDependencies(): LifecycleDependencies
    fun createCoilDependencies(): CoilDependencies
    fun createKotlinXDependencies(): KotlinXDependencies

    class Default(private val factory: ConfigurationExtensionFactory) : DependencyFactory {
        private val extension: KotlinMultiplatformExtension by lazy { factory.multiplatformExtension }
        private val composeExtension: ComposeExtension by lazy { factory.composeExtension }

        override fun createMultiplatformDependencies() = CoroutineDependencies(extension)
        override fun createComposeDependencies() = ComposeDependencies(composeExtension, extension)
        override fun createKoinDependencies() = KoinDependencies(extension)
        override fun createKtorDependencies() = KtorDependencies(extension)
        override fun createRoomDependencies() = RoomDependencies(extension)
        override fun createDataStoreDependencies() = DataStoreDependencies(extension)
        override fun createLifecycleDependencies() = LifecycleDependencies(extension)
        override fun createCoilDependencies() = CoilDependencies(extension)
        override fun createKotlinXDependencies(): KotlinXDependencies = KotlinXDependencies(extension)
    }
}