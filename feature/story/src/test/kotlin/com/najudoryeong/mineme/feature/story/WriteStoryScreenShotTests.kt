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

package com.najudoryeong.mineme.feature.story

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.testing.util.captureMultiDevice
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode
import java.time.LocalDate

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class, sdk = [33])
@LooperMode(LooperMode.Mode.PAUSED)
class WriteStoryScreenShotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun writeStoryFirstPageScreen() {
        composeTestRule.captureMultiDevice("FirstPage") {
            DoTheme {
                WriteStoryFirstPageScreen(
                    allRegions = koreanProvinces,
                    allCities = koreanCities[koreanProvinces.first()] ?: emptyList(),
                    selectedDate = LocalDate.now(),
                )
            }
        }
    }

    @Test
    fun writeStorySecondPageScreen() {
        val mockUris = listOf(
            Uri.parse("https://example.com/image1.jpg"),
            Uri.parse("https://example.com/image2.jpg"),
        )
        val mockStoryContent = mutableStateOf("This is a sample story content.")

        composeTestRule.captureMultiDevice("SecondPage") {
            DoTheme {
                WriteStorySecondPageScreen(
                    selectedDate = LocalDate.now(),
                    selectedRegion = "서울특별시",
                    selectedCity = "강남구",
                    selectedImages = mockUris,
                    storyContent = mockStoryContent,
                )
            }
        }
    }
}
