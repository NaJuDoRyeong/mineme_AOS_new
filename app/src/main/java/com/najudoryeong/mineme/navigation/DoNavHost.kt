package com.najudoryeong.mineme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.najudoryeong.mineme.feature.home.navigation.homeNavigationRoute
import com.najudoryeong.mineme.feature.home.navigation.homeScreen
import com.najudoryeong.mineme.feature.story.navigation.navigateToDetailStory
import com.najudoryeong.mineme.feature.story.navigation.settingsScreen
import com.najudoryeong.mineme.feature.story.navigation.storyScreen
import com.najudoryeong.mineme.feature.story.navigation.writeStoryScreen
import com.najudoryeong.mineme.ui.DoAppState

@Composable
fun DoNavHost(
    appState: DoAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {

        homeScreen()

        //todo onStoryClick
        storyScreen(onStoryClick = navController::navigateToDetailStory
            , showCalendar = appState.shouldShowCalendar)

        writeStoryScreen(
            onBackClick = navController::popBackStack
        )

        settingsScreen()
    }
}
