package com.najudoryeong.mineme

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import kotlin.properties.ReadOnlyProperty
import com.najudoryeong.mineme.feature.home.R as FeatureHomeR
import com.najudoryeong.mineme.feature.story.R as FeatureStoryR
import com.najudoryeong.mineme.feature.settings.R as FeatureSettingsR

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
    fun setup() = hiltRule.inject()

    @Test
    fun firstScreen_isHome() {
        composeTestRule.apply {
            onNodeWithText(home).assertIsSelected()
        }
    }


    //todo  restore the state  previously visited destinations Test
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

}