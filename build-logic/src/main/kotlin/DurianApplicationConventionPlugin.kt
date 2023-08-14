import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.longthien.durian.configureBuildType
import com.longthien.durian.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class DurianApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure(BaseAppModuleExtension::class.java) {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}