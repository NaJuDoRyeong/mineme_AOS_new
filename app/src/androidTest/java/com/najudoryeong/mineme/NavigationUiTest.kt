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

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.google.accompanist.testharness.TestHarness
import com.najudoryeong.mineme.core.data.util.NetworkMonitor
import com.najudoryeong.mineme.ui.DoApp
import com.najudoryeong.mineme.uitesthiltmanifest.HiltComponentActivity
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import javax.inject.Inject

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@HiltAndroidTest
class NavigationUiTest {

    /**
     * Manages the components' state and is used to perform injection on your test
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @BindValue
    @get:Rule(order = 1)
    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<HiltComponentActivity>()

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun compactWidth_compactHeight_showsNavigationBar() {
        composeTestRule.setContent {
            TestHarness(size = DpSize(400.dp, 400.dp)) {
                BoxWithConstraints {
                    DoApp(
                        windowSizeClass = WindowSizeClass.calculateFromSize(
                            DpSize(maxWidth, maxHeight),
                        ),
                        networkMonitor = networkMonitor,
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag("DoBottomBar").assertIsDisplayed()
    }
}
