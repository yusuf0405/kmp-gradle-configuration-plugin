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

internal interface DependencyFactory {
    fun createCoroutineDependencies(): CoroutineDependencies
    fun createComposeDependencies(): ComposeDependencies
    fun createKoinDependencies(): KoinDependencies
    fun createKtorDependencies(): KtorDependencies
    fun createRoomDependencies(): RoomDependencies
    fun createDataStoreDependencies(): DataStoreDependencies
    fun createLifecycleDependencies(): LifecycleDependencies
    fun createCoilDependencies(): CoilDependencies
    fun createKotlinXDependencies(): KotlinXDependencies

    class Default : DependencyFactory {
        override fun createCoroutineDependencies() = CoroutineDependencies()
        override fun createComposeDependencies() = ComposeDependencies()
        override fun createKoinDependencies() = KoinDependencies()
        override fun createKtorDependencies() = KtorDependencies()
        override fun createRoomDependencies() = RoomDependencies()
        override fun createDataStoreDependencies() = DataStoreDependencies()
        override fun createLifecycleDependencies() = LifecycleDependencies()
        override fun createCoilDependencies() = CoilDependencies()
        override fun createKotlinXDependencies(): KotlinXDependencies = KotlinXDependencies()
    }
}