package com.najudoryeong.mineme.navigation

import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    Home(
    ),
    Story(
    ),
    Setting(
    )
}