# KMP Configuration Plugin

## Overview

This Gradle plugin simplifies the configuration of Kotlin Multiplatform (KMP) projects by providing
predefined dependencies and configurations for common libraries like Ktor, Koin, Room, and more. It
ensures that necessary extensions for Compose Multiplatform and Android are correctly set up.

## Features

- **Multiplatform Support**: Adds Kotlin Multiplatform extension.
- **Compose Integration**: Ensures Compose Multiplatform extension is available.
- **Dependency Management**: Preconfigured dependencies for:
    - Coroutines
    - Compose
    - Koin
    - Ktor
    - Room
    - DataStore
    - Lifecycle
    - Coil
- **Android Configurations**:
    - Supports both Application and Library modules.
    - Configures Android-specific settings.

## Installation

Add the plugin to your Gradle project:

```kotlin
plugins {
    id("io.joseph.kmp.configuration") version "<last-version>"
}
```

## Usage

Once applied, the plugin automatically configures your KMP project. You can access the configuration
via:

```kotlin
kmpConfiguration { 
    // Configure dependencies and settings if needed
    compose.configureDependencies()
    koin.configureDependencies()
}
```

## Requirements

- Kotlin Multiplatform
- Compose Multiplatform (if used)
- Android Gradle Plugin (for Android modules)

## License

This project is licensed under the MIT License.



