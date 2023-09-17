plugins {
    id("mineme.android.library")
    id("mineme.android.library.compose")
    id("mineme.android.hilt")
}
android {
    namespace = "com.najudoryeong.mineme.core.analytics"
}


dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.firebase.analytics)
    implementation(libs.kotlinx.coroutines.android)
}
