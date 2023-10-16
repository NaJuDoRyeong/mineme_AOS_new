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
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import org.junit.Rule
import org.junit.Test

class StoryScreenTest {

    @get:Rule(order = 0)
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun circularProgressIndicator_whenCalendarScreenIsLoading_exists() {
        composeTestRule.setContent {
            BoxWithConstraints {
                StoryScreen(
                    shouldShowCalendar = true,
                    regionState = RegionStoryUiState.Loading,
                    calendarState = CalendarStoryUiState.Loading,
                )
            }
        }
        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.resources.getString(R.string.calendar_loading),
            )
            .assertExists()
    }

    @Test
    fun circularProgressIndicator_whenRegionScreenIsLoading_exists() {
        composeTestRule.setContent {
            BoxWithConstraints {
                StoryScreen(
                    shouldShowCalendar = false,
                    regionState = RegionStoryUiState.Loading,
                    calendarState = CalendarStoryUiState.Loading,
                )
            }
        }
        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.resources.getString(R.string.region_loading),
            )
            .assertExists()
    }
}
