plugins {
    id("mineme.android.library")
    id("mineme.android.library.compose")
    id("mineme.android.hilt")
}

android {
    namespace = "com.najudoryeong.mineme.core.notifications"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.cloud.messaging)
}
