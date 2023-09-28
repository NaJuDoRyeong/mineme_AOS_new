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
                    selectedDate = LocalDate.now()
                )
            }
        }
    }


    @Test
    fun writeStorySecondPageScreen() {
        val mockUris = listOf(
            Uri.parse("https://example.com/image1.jpg"),
            Uri.parse("https://example.com/image2.jpg")
        )
        val mockStoryContent = mutableStateOf("This is a sample story content.")

        composeTestRule.captureMultiDevice("SecondPage") {
            DoTheme {
                WriteStorySecondPageScreen(
                    selectedDate = LocalDate.now(),
                    selectedRegion = "서울특별시",
                    selectedCity = "강남구",
                    selectedImages = mockUris,
                    storyContent = mockStoryContent
                )
            }
        }
    }


}