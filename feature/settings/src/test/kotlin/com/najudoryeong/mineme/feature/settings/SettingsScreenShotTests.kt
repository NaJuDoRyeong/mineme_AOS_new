package com.najudoryeong.mineme.feature.settings

import android.accounts.Account
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
                            "test_mineCode"
                        )
                    )
                )
            }
        }
    }
}
