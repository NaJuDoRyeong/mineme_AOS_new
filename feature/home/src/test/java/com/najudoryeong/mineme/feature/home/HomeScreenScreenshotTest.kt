package com.najudoryeong.mineme.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
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

/**
 * Screenshot tests for the [HomeScreen].
 */
@RunWith(RobolectricTestRunner::class) // Android 코드를 JVM에서 실행 테스트러너
@GraphicsMode(GraphicsMode.Mode.NATIVE) // Robolectric 테스트에서 사용할 그래픽 모드를 지정
@Config(application = HiltTestApplication::class, sdk = [33]) //
@LooperMode(LooperMode.Mode.PAUSED)
class HomeScreenScreenshotTests {


    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val homeMainResources = HomeMainResourcePreviewParameterProvider().values.first()

    @Before
    fun setTimeZone() {
        // Make time zone deterministic in tests
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }


}