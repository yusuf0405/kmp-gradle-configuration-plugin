import di.Injector
import org.gradle.api.Plugin
import org.gradle.api.Project

private const val EXTENSION_NAME = "kmpConfiguration"

public class KmpConfigurationPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        Injector.setProject(target)
        target.extensions.create(
            EXTENSION_NAME,
            KmpConfigurationExtension::class.java
        )
        plugins.apply("org.jetbrains.kotlin.multiplatform")
    }
}