# KmpConfigurationPlugin

The `KmpConfigurationPlugin` is a Gradle plugin designed to automatically configure Kotlin
Multiplatform (KMP) projects based on whether the project is an Android Application or an Android
Library. It simplifies the process of setting up dependencies and configurations for Android, Kotlin
Multiplatform, and Compose.

## Features

- Automatically configures the project based on the presence of the `com.android.application` or
  `com.android.library` plugin.
- Can be applied after `com.android.application` or `com.android.library` plugins.
- Simplifies the setup of Kotlin Multiplatform configurations for Android applications and
  libraries.
- Preconfigured dependencies for:
  - Coroutines
  - Compose
  - Koin
  - Ktor
  - Room
  - DataStore
  - Lifecycle
  - Coil

## Prerequisites

- Gradle 7.x or higher.
- Android Gradle Plugin 8.x or higher.
- Kotlin 1.6 or higher.

## Installation

Add the following to your `settings.gradle.kts` to ensure that the plugin is available:

```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
    }
}
```

In your `build.gradle.kts` file, add the following plugin declarations:

```kotlin
plugins {
    alias(libs.plugins.android.library)  // For Android Library
    alias(libs.plugins.kmp.configuration) // KMP Configuration Plugin
}
```

The `KmpConfigurationPlugin` must be applied after either the `com.android.library` or
`com.android.application` plugin.

## Usage

The plugin automatically configures your project based on the type of Android plugin you use. You
can configure dependencies for Kotlin Coroutines, KotlinX, Lifecycle, and Compose Multiplatform.

### 1. Android Library Setup

```kotlin
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kmp.configuration) // Register KMP Configuration Plugin
}

kotlin {
    with(
        configuration = kmpConfiguration,
        extension = this,
    ) { configuration, extension ->
        // Configure dependencies for Kotlin Coroutines, KotlinX, and Lifecycle
        configuration.coroutine.configureDependencies(extension)
        configuration.kotlinX.configureDependencies(extension)
        configuration.lifecycle.configureDependencies(extension)
    }
}
```

### 2. Android Library with Compose Setup

```kotlin
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kmp.configuration) // Register KMP Configuration Plugin
}

kotlin {
    with(
        configuration = kmpConfiguration,
        extension = this,
        composeDependencies = compose
    ) { configuration, extension, composeDependencies ->
        // Configure dependencies for Compose Multiplatform
        configuration.coroutine.configureDependencies(extension)
        configuration.compose.configureDependencies(extension, composeDependencies)
        configuration.kotlinX.configureDependencies(extension)
        configuration.lifecycle.configureDependencies(extension)
    }
}
```

### Key Points

- **Automatic Configuration**: The plugin automatically detects whether the project is an Android
  application or an Android library and applies the appropriate configurations.
- **Flexible Dependency Configuration**: The plugin provides an easy way to configure dependencies
  for Kotlin Coroutines, KotlinX, Lifecycle, and Compose Multiplatform.
- **Sequential Plugin Registration**: The `kmp.configuration` plugin should always be registered
  after the `com.android.library` or `com.android.application` plugin, as shown in the examples
  above.

## Configuration

The plugin will configure the project based on the type of Android plugin (`com.android.application`
or `com.android.library`) that is used. The configuration logic for both Android applications and
libraries is automatically applied.

### Available Configuration Methods

- `configuration.coroutine.configureDependencies(extension)` - Configures dependencies for Kotlin
  Coroutines.
- `configuration.kotlinX.configureDependencies(extension)` - Configures dependencies for KotlinX.
- `configuration.lifecycle.configureDependencies(extension)` - Configures dependencies for
  Lifecycle.
- `configuration.compose.configureDependencies(extension, composeDependencies)` - Configures
  dependencies for Compose Multiplatform (only for projects using Compose).

### Project Type Detection

- **Android Application**: The plugin detects if the project is an Android application using the
  `com.android.application` plugin and applies the `applicationConfigurator`.
- **Android Library**: The plugin detects if the project is an Android library using the
  `com.android.library` plugin and applies the `libraryConfigurator`.

## License

This plugin is licensed under the MIT License. See the LICENSE file for more details.