plugins {
    id("mineme.android.library")
    id("mineme.android.library.jacoco")
    id("mineme.android.hilt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.najudoryeong.mineme.core.testing.DoTestRunner"
    }
    namespace = "com.najudoryeong.mineme.sync"
}

dependencies {
    implementation(project(":core:analytics"))
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.work.ktx)
    implementation(libs.firebase.cloud.messaging)
    implementation(libs.hilt.ext.work)
    implementation(libs.kotlinx.coroutines.android)

    kapt(libs.hilt.ext.compiler)

    testImplementation(project(":core:testing"))

    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(libs.androidx.work.testing)
}
