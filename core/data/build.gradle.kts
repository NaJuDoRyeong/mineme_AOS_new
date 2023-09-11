plugins {
    id("mineme.android.library")
    id("mineme.android.library.jacoco")
    id("mineme.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.najudoryeong.mineme.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(project(":core:model"))

    
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
