import com.android.build.api.dsl.LibraryExtension
import com.longthien.durian.configureBuildType
import com.longthien.durian.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class DurianLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure(LibraryExtension::class.java) {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}