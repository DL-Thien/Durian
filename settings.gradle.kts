pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Durian"
include(":app")
include(":core-network")
include(":core-localstorage")
include(":core-common")
include(":core-data")

include(":core-designSystem")
include(":core-model")
include(":core-theme")
include(":core-navigation")
