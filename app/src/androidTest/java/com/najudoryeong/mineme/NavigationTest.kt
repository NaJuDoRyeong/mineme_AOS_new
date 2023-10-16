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

package com.najudoryeong.mineme

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import kotlin.properties.ReadOnlyProperty
import com.najudoryeong.mineme.feature.home.R as FeatureHomeR
import com.najudoryeong.mineme.feature.settings.R as FeatureSettingsR
import com.najudoryeong.mineme.feature.story.R as FeatureStoryR

@HiltAndroidTest
class NavigationTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @BindValue
    @get:Rule(order = 1)
    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun AndroidComposeTestRule<*, *>.stringResource(@StringRes resId: Int) =
        ReadOnlyProperty<Any?, String> { _, _ -> activity.getString(resId) }

    private val navigateUp by composeTestRule.stringResource(FeatureHomeR.string.navigate_up)
    private val home by composeTestRule.stringResource(FeatureHomeR.string.home)
    private val story by composeTestRule.stringResource(FeatureStoryR.string.story)
    private val settings by composeTestRule.stringResource(FeatureSettingsR.string.settings)

    @Before
    fun setup() {
        hiltRule.inject()
        composeTestRule.apply {
            val kakaoSignupText = composeTestRule.activity.getString(R.string.kakao_signup)
            onNodeWithText(kakaoSignupText).performClick()
        }
    }

    @Test
    fun firstScreen_isHome() {
        composeTestRule.apply {
            onNodeWithText(home).assertIsSelected()
        }
    }

    @Test
    fun topLevelDestinations_doNotShowUpArrow() {
        composeTestRule.apply {
            onNodeWithContentDescription(navigateUp).assertDoesNotExist()

            onNodeWithText(story).performClick()
            onNodeWithContentDescription(navigateUp).assertDoesNotExist()

            onNodeWithText(settings).performClick()
            onNodeWithContentDescription(navigateUp).assertDoesNotExist()
        }
    }

    // homeDestination back 을 하면 종료 Test
    // NoActivityResumedException가 발생해야 통과 , 즉 앱종료
    @Test(expected = NoActivityResumedException::class)
    fun homeDestination_back_quitsApp() {
        composeTestRule.apply {
            onNodeWithText(settings).performClick()
            onNodeWithText(home).performClick()

            Espresso.pressBack()
        }
    }

    // 다른 topDestination 에서 back homeDestinatnion 으로 가는지 Test
    @Test
    fun navigationBar_backFromAnyDestination_returnsToHome() {
        composeTestRule.apply {
            onNodeWithText(settings).performClick()
            Espresso.pressBack()
            onNodeWithText(home).assertExists()

            onNodeWithText(story).performClick()
            Espresso.pressBack()
            onNodeWithText(home).assertExists()
        }
    }
}
