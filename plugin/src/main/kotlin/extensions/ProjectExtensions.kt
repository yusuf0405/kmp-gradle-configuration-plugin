package extensions

internal fun dependency(groupWithArtifact: String, version: String): String {
    return "$groupWithArtifact:$version"
}