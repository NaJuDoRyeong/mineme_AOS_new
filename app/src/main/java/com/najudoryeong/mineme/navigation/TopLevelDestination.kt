package com.najudoryeong.mineme.navigation

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    Home(
        selectedIcon = DoIcons.HomeBorder,
        unselectedIcon = DoIcons.Home,
        iconTextId = forYouR.string.for_you,
        titleTextId = R.string.app_name,
    ),
    Story(
        selectedIcon = DoIcons.StoryBorder,
        unselectedIcon = DoIcons.Story,
        iconTextId = bookmarksR.string.saved,
        titleTextId = bookmarksR.string.saved,
    ),
    Setting(
        selectedIcon = DoIcons.SettingBorder,
        unselectedIcon = DoIcons.Setting,
        iconTextId = interestsR.string.interests,
        titleTextId = interestsR.string.interests,
    )
}