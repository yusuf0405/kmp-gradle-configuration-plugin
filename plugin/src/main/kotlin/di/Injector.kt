package di

import KmpDependencyFacade
import factories.DependencyFactory

internal object Injector {

    private val dependencyFactory: DependencyFactory by lazy {
        DependencyFactory.Default()
    }

    val facade: KmpDependencyFacade by lazy {
        KmpDependencyFacade(factory = dependencyFactory)
    }
}