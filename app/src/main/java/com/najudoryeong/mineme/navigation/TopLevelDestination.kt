package com.najudoryeong.mineme.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.najudoryeong.mineme.R
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.feature.home.R as homeR
import com.najudoryeong.mineme.feature.story.R as storyR
import com.najudoryeong.mineme.feature.settings.R as settingsR
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    Home(
        selectedIcon = DoIcons.HomeBorder,
        unselectedIcon = DoIcons.Home,
        iconTextId = homeR.string.home,
        titleTextId = R.string.app_name
    ),
    Story(
        selectedIcon = DoIcons.StoryBorder,
        unselectedIcon = DoIcons.Story,
        iconTextId = storyR.string.story,
        titleTextId = storyR.string.story,
    ),
    Setting(
        selectedIcon = DoIcons.SettingBorder,
        unselectedIcon = DoIcons.Setting,
        iconTextId = settingsR.string.settings,
        titleTextId = settingsR.string.settings,
    )
}