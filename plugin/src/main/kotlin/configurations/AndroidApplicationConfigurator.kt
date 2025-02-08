package configurations

import com.android.build.api.dsl.ApplicationExtension
import versions.Versions

public class AndroidApplicationConfigurator {
    public fun configure(extension: ApplicationExtension): ApplicationExtension = extension.apply {
        compileSdk = Versions.androidCompileSdk
        defaultConfig {
            minSdk = Versions.androidMinSdk
            targetSdk = Versions.androidTargetSdk
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