package com.najudoryeong.mineme.feature.story.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.najudoryeong.mineme.feature.story.SettingsRoute

const val settingsNavigationRoute = "settings_route"
fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate(settingsNavigationRoute, navOptions)
}


fun NavGraphBuilder.settingsScreen() {
    composable(
        route = settingsNavigationRoute,
    ) {
        SettingsRoute()
    }
}
