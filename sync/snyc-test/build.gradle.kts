plugins {
    id("mineme.android.library")
    id("mineme.android.hilt")
}

android {
    namespace = "com.najudoryeong.mineme.core.sync.test"
}

dependencies {
    api(project(":sync:work"))
    implementation(project(":core:data"))
    implementation(project(":core:testing"))
}
