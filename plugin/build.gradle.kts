plugins {
    id("shared")
    id("java-gradle-plugin")
    alias(libs.plugins.plugin.publish)
    id("com.vanniktech.maven.publish") version "0.30.0"
    signing
}
group = libs.versions.groudId.get()
version = libs.versions.version.get()

gradlePlugin {
    website = "https://github.com/yusuf0405/kmp-gradle-configuration-plugin"
    vcsUrl = "https://github.com/yusuf0405/kmp-gradle-configuration-plugin"
    plugins {
        register("io.joseph.kmp.configuration") {
            id = "io.joseph.kmp.configuration"
            implementationClass = "KmpConfigurationPlugin"
            displayName = "Gradle Kotlin Multiplatform Configuration Plugin"
            description = "Gradle plugin for configuring Kotlin Multiplatform projects"
            tags.set(listOf("kotlin", "kmp", "configuration", "gradle-plugin"))
        }
    }
}

kotlin { explicitApi() }
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}
java {
    withSourcesJar()
    withJavadocJar()
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}