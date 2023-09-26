package com.najudoryeong.mineme.feature.story

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.testing.util.captureMultiDevice
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.HomeUiState
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
                        storyRegionResource = storyRegionResource
                    ),
                    calendarState = CalendarStoryUiState.Success(
                        storyCalendarResource = storyCalendarResource,
                        year = "2023",
                        month = "09"
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
                        storyRegionResource = storyRegionResourceEmpty
                    ),
                    calendarState = CalendarStoryUiState.Success(
                        storyCalendarResource = storyCalendarResource,
                        year = "2023",
                        month = "09"
                    ),
                )
            }
        }
    }



}