package com.najudoryeong.mineme.navigation

import com.najudoryeong.mineme.R
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.designsystem.icon.Icon
import com.najudoryeong.mineme.feature.home.R as homeR
import com.najudoryeong.mineme.feature.story.R as storyR
import com.najudoryeong.mineme.feature.settings.R as settingsR

//todo 각 페이지 데이터 추가
enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val navigationIcon : Int = DoIcons.Story.resourceId,
    val actionIcon : Int = DoIcons.settings.resourceId,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    Home(
        selectedIcon = DoIcons.OnHome.resourceId,
        unselectedIcon = DoIcons.Home.resourceId,
        iconTextId = homeR.string.home,
        titleTextId = R.string.app_name
    ),
    Story(
        selectedIcon = DoIcons.OnStory.resourceId,
        unselectedIcon = DoIcons.Story.resourceId,
        iconTextId = storyR.string.story,
        titleTextId = storyR.string.story,
    ),
    settings(
        selectedIcon = DoIcons.OnSettings.resourceId,
        unselectedIcon = DoIcons.settings.resourceId,
        iconTextId = settingsR.string.settings,
        titleTextId = settingsR.string.settings,
    )
}