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

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.testing.util.captureMultiDevice
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import com.najudoryeong.mineme.core.ui.StoryCalendarResourcePreviewParameterProvider
import com.najudoryeong.mineme.core.ui.StoryRegionResourcePreviewParameterProvider
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode
import java.util.TimeZone

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class, sdk = [33])
@LooperMode(LooperMode.Mode.PAUSED)
class StoryScreenShotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

    private val storyCalendarResource = StoryCalendarResourcePreviewParameterProvider().values.first()
    private val storyRegionResource = StoryRegionResourcePreviewParameterProvider().values.first()
    private val storyRegionResourceEmpty = StoryRegionResourcePreviewParameterProvider().values.drop(1).first()

    @Test
    fun storyRegionScreen() {
        composeTestRule.captureMultiDevice("StoryRegion") {
            DoTheme {
                StoryScreen(
                    shouldShowCalendar = false,
                    regionState = RegionStoryUiState.Success(
                        storyRegionResource = storyRegionResource,
                    ),
                    calendarState = CalendarStoryUiState.Success(
                        storyCalendarResource = storyCalendarResource,
                        year = "2023",
                        month = "09",
                    ),
                )
            }
        }
    }

    @Test
    fun storyRegionEmptyScreen() {
        composeTestRule.captureMultiDevice("StoryRegion") {
            DoTheme {
                StoryScreen(
                    shouldShowCalendar = false,
                    regionState = RegionStoryUiState.Success(
                        storyRegionResource = storyRegionResourceEmpty,
                    ),
                    calendarState = CalendarStoryUiState.Success(
                        storyCalendarResource = storyCalendarResource,
                        year = "2023",
                        month = "09",
                    ),
                )
            }
        }
    }
}
