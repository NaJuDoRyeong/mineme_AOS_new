package com.najudoryeong.mineme.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import com.najudoryeong.mineme.PACKAGE_NAME
import com.najudoryeong.mineme.home.homeYouWaitForContent
import com.najudoryeong.mineme.settings.goToSettingsScreen
import com.najudoryeong.mineme.story.goToDetailStory
import com.najudoryeong.mineme.story.goToStory
import com.najudoryeong.mineme.story.selectRegionFromDropdown
import com.najudoryeong.mineme.story.storyScrollPostDownUp
import com.najudoryeong.mineme.story.storyWaitForPost
import org.junit.Rule
import org.junit.Test

class BaselineProfileGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()


    @Test
    fun generate() =
        baselineProfileRule.collect(PACKAGE_NAME) {

            pressHome()
            startActivityAndWait()

            homeYouWaitForContent()

            //goToStory
            goToStory()
            storyWaitForPost()

            // scroll Region and select Region
            storyScrollPostDownUp("story:posts")
            selectRegionFromDropdown("경남")

            // goToDetail and Scroll
            goToDetailStory()
            storyScrollPostDownUp("detail:posts")
        }
}


