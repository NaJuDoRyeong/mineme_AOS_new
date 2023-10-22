/*
 * Copyright 2023 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.najudoryeong.mineme.DoBuildType

plugins {
    id("mineme.android.application")
    id("mineme.android.application.compose")
    id("mineme.android.application.flavors")
    id("mineme.android.application.jacoco")
    id("mineme.android.hilt")
    id("jacoco")
}

android {
    namespace = "com.najudoryeong.mineme"

    defaultConfig {
        applicationId = "com.najudoryeong.mineme"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.najudoryeong.mineme.core.testing.DoTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = DoBuildType.DEBUG.applicationIdSuffix
            manifestPlaceholders["appName"] = "Mineme (Debug)"
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = DoBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
            manifestPlaceholders["appName"] = "Mineme"
        }
        create("benchmark") {
            initWith(release)
            matchingFallbacks.add("release")
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = DoBuildType.BENCHMARK.applicationIdSuffix
            manifestPlaceholders["appName"] = "Mineme (Benchmark)"
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }


}
dependencies {

    implementation(project(":feature:home"))
    implementation(project(":feature:story"))
    implementation(project(":feature:settings"))

    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(project(":core:datastore-test"))
    androidTestImplementation(project(":core:data-test"))
    androidTestImplementation(project(":core:network"))
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.accompanist.testharness)
    androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.testManifest)
    debugImplementation(project(":ui-test-hilt-manifest"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    // Core functions
    testImplementation(project(":core:testing"))
    testImplementation(project(":core:datastore-test"))
    testImplementation(project(":core:data-test"))
    testImplementation(project(":core:network"))
    testImplementation(libs.androidx.navigation.testing)
    testImplementation(libs.accompanist.testharness)
    testImplementation(kotlin("test"))
    implementation(libs.work.testing)
    kaptTest(libs.hilt.compiler)
}
