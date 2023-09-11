
plugins {
    id("mineme.android.feature")
    id("mineme.android.library.compose")
    id("mineme.android.library.jacoco")
}

android {
    namespace = "com.najudoryeong.mineme.feature.settings"
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}