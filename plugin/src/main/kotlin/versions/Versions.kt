package versions

import org.gradle.api.JavaVersion

public object Versions {
    // https://github.com/Kotlin/kotlinx.coroutines/releases
    public const val coroutineVersion: String = "1.10.1"

    // https://github.com/InsertKoinIO/koin/releases
    public const val koinVersion: String = "4.0.1"

    // https://github.com/ktorio/ktor/releases
    public const val ktorVersion: String = "3.0.3"

    // https://developer.android.google.cn/kotlin/multiplatform/room?hl=en
    public const val roomVersion: String = "2.7.0-alpha08"
    public const val sqliteVersion: String = "2.5.0-alpha07"

    // https://developer.android.com/topic/libraries/architecture/datastore?hl=ru
    public const val dataStoreVersion: String = "1.1.2"

    // https://developer.android.com/jetpack/androidx/releases/lifecycle?hl=ru
    public const val lifecycleVersion: String = "2.8.4"

    // https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html?ysclid=m6m2bn1jv6508838107#setup
    public const val navigationCompose: String = "2.8.0-alpha10"

    public const val coilVersion: String = "3.0.4"
    public const val kotlinxSerializationVersion: String = "1.7.3"
    public const val kotlinxDatetimeVersion: String = "0.6.1"

    public val javaVersion: JavaVersion = JavaVersion.VERSION_17
    public const val jvmTarget: Int = 17

    public const val androidMinSdk: Int = 24
    public const val androidCompileSdk: Int = 35
    public const val androidTargetSdk: Int = 35

    public const val kotlinCompilerExtensionVersion: String = "1.5.15"
}