package com.najudoryeong.mineme.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.najudoryeong.mineme.core.ui.HomeUiState
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule(order = 0)
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun circularProgressIndicator_whenScreenIsLoading_exists() {
        composeTestRule.setContent {
            BoxWithConstraints {
                HomeScreen(
                    homeState = HomeUiState.Loading
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.resources.getString(R.string.home_loading),
            )
            .assertExists()
    }

}