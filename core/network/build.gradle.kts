plugins {
    id("mineme.android.library")
    id("mineme.android.library.jacoco")
    id("mineme.android.hilt")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.najudoryeong.mineme.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    testImplementation(project(":core:testing"))
}
