package di

import factories.ConfigurationExtensionFactory
import factories.DependencyFactory
import KmpDependencyFacade
import org.gradle.api.Project

internal object Injector {

    private var project: Project? = null

    private val configurationExtensionFactory: ConfigurationExtensionFactory by lazy {
        ConfigurationExtensionFactory.Default(getProject())
    }

    private val dependencyFactory: DependencyFactory by lazy {
        DependencyFactory.Default(configurationExtensionFactory)
    }

    val facade: KmpDependencyFacade by lazy {
        KmpDependencyFacade(
            factory = dependencyFactory,
            extensionFactory = configurationExtensionFactory
        )
    }

    fun setProject(project: Project) {
        Injector.project = project
    }

    private fun getProject(): Project {
        return checkNotNull(project) { "Project not set" }
    }
}