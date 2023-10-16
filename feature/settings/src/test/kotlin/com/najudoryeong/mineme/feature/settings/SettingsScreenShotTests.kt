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

package com.najudoryeong.mineme.feature.settings

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.testing.util.captureMultiDevice
import com.najudoryeong.mineme.core.ui.AccountUiState
import com.najudoryeong.mineme.feature.story.AccountScreen
import com.najudoryeong.mineme.feature.story.SettingsScreen
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class, sdk = [33])
@LooperMode(LooperMode.Mode.PAUSED)
class SettingsScreenShotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun settingMainScreen() {
        composeTestRule.captureMultiDevice("setting_main") {
            DoTheme {
                SettingsScreen(
                    navController = NavController(LocalContext.current),
                )
            }
        }
    }

    @Test
    fun accountScreen() {
        composeTestRule.captureMultiDevice("setting_account") {
            DoTheme {
                AccountScreen(
                    accountState = AccountUiState.Success(
                        Code(
                            "test_myCode",
                            "test_mineCode",
                        ),
                    ),
                )
            }
        }
    }
}
