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

package com.najudoryeong.mineme.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import com.najudoryeong.mineme.PACKAGE_NAME
import com.najudoryeong.mineme.home.homeWaitForContent
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

            homeWaitForContent()

            // goToStory
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
