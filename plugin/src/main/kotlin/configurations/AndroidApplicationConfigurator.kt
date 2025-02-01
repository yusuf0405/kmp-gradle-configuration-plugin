package configurations

import com.android.build.api.dsl.ApplicationExtension
import versions.Versions

public data class AndroidApplicationConfig(
    val applicationId: String,
    val versionCode: Int,
    val versionName: String,
)

public class AndroidApplicationConfigurator(
    private val extension: ApplicationExtension,
) {

    public fun configure(config: AndroidApplicationConfig): ApplicationExtension = extension.apply {
        compileSdk = Versions.androidCompileSdk
        defaultConfig {
            minSdk = Versions.androidMinSdk
            targetSdk = Versions.androidTargetSdk
            applicationId = config.applicationId
            versionCode = config.versionCode
            versionName = config.versionName
        }
        packaging.resources {
            pickFirsts += "/META-INF/LICENSE.md"
            pickFirsts += "/META-INF/LICENSE-notice.md"
            pickFirsts += "/META-INF/AL2.0"
            pickFirsts += "/META-INF/LGPL2.1"
            pickFirsts += "META-INF/versions/9/previous-compilation-data.bin"
        }
        compileOptions {
            sourceCompatibility = Versions.javaVersion
            targetCompatibility = Versions.javaVersion
        }
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
        }
    }
}