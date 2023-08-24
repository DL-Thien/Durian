plugins {
//    id("com.android.library")
//    id("org.jetbrains.kotlin.android")

    id("durian-android-library")
    id("durian-hilt")
}

android {
    namespace = "com.longthien.core.data"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {

    implementation(libs.android.core.ktx)
    implementation(libs.coroutines.android)
    implementation(project(":core-network"))
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}