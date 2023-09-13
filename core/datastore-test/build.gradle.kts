plugins {
    id("mineme.android.library")
    id("mineme.android.hilt")
}

android {
    namespace = "com.najudoryeong.mineme.core.datastore.test"
}

dependencies {
    api(project(":core:datastore"))
    api(libs.androidx.dataStore.core)

    implementation(libs.protobuf.kotlin.lite)
    implementation(project(":core:common"))
    implementation(project(":core:testing"))
}
