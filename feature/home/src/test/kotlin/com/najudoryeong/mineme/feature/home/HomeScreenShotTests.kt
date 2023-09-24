package com.najudoryeong.mineme.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.testing.util.captureMultiDevice
import com.najudoryeong.mineme.core.ui.HomeMainResourcePreviewParameterProvider
import com.najudoryeong.mineme.core.ui.HomeUiState
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
class HomeScreenShotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setTimeZone() {
        // Make time zone deterministic in tests
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }


    private val homeMainResource = HomeMainResourcePreviewParameterProvider().values.first()
    private val homeMainResourceNoStory = HomeMainResourcePreviewParameterProvider().values.drop(1).first()

    // HomeMainResource를 채운후 스크린샷을 캡쳐
    @Test
    fun homeScreenPopulatedResource() {
        composeTestRule.captureMultiDevice("HomeScreenPopulatedResource") {
            DoTheme {
                HomeScreen(
                    homeState = HomeUiState.Success(
                        homeMainResource = homeMainResource
                    )
                )
            }
        }
    }


    // noSotry
    @Test
    fun homeScreenPopulatedResourceNoStory() {
        composeTestRule.captureMultiDevice("HomeScreenPopulatedResourceNoStory") {
            DoTheme {
                HomeScreen(
                    homeState = HomeUiState.Success(
                        homeMainResource = homeMainResourceNoStory
                    )
                )
            }
        }
    }


    // Loading 화면 캡쳐
    @Test
    fun homeScreenLoading() {
        composeTestRule.captureMultiDevice("HomeScreenLoading") {
            DoTheme {
                HomeScreen(
                    homeState = HomeUiState.Loading
                )
            }
        }
    }
}