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

package com.najudoryeong.mineme.navigation

import com.najudoryeong.mineme.R
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.feature.home.R as homeR
import com.najudoryeong.mineme.feature.settings.R as settingsR
import com.najudoryeong.mineme.feature.story.R as storyR

// todo 각 페이지 데이터 추가
enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val actionIcon: Int = DoIcons.settings.resourceId,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    Home(
        selectedIcon = DoIcons.OnHome.resourceId,
        unselectedIcon = DoIcons.Home.resourceId,
        iconTextId = homeR.string.home,
        titleTextId = R.string.app_name,
    ),
    Story(
        selectedIcon = DoIcons.OnStory.resourceId,
        unselectedIcon = DoIcons.Story.resourceId,
        iconTextId = storyR.string.story,
        titleTextId = storyR.string.story,
        actionIcon = DoIcons.write_story.resourceId,
    ),
    Settings(
        selectedIcon = DoIcons.OnSettings.resourceId,
        unselectedIcon = DoIcons.settings.resourceId,
        iconTextId = settingsR.string.settings,
        titleTextId = settingsR.string.settings,
    ),
}
