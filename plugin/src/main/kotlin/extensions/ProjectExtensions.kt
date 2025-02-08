package extensions

import KmpConfigurationExtension
import org.jetbrains.compose.ComposePlugin

internal fun dependency(groupWithArtifact: String, version: String): String {
    return "$groupWithArtifact:$version"
}

public fun <T> with(
    configuration: KmpConfigurationExtension,
    extension: T,
    composeDependencies: ComposePlugin.Dependencies,
    block: (KmpConfigurationExtension, T, ComposePlugin.Dependencies) -> Unit
) {
    block(configuration, extension, composeDependencies)
}

public fun <T> with(
    configuration: KmpConfigurationExtension,
    extension: T,
    block: (KmpConfigurationExtension, T) -> Unit
) {
    block(configuration, extension)
}