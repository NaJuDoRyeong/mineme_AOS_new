package com.najudoryeong.mineme.feature.story.navigation

import android.net.Uri
import androidx.annotation.VisibleForTesting
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.najudoryeong.mineme.feature.story.StoryRoute
import com.najudoryeong.mineme.feature.story.WriteStoryRoute
import kotlinx.coroutines.flow.MutableStateFlow

const val storyNavigationRoute = "story_route"
const val storyWriteRoute = "story_write_route"


fun NavController.navigateToStory(navOptions: NavOptions? = null) {
    this.navigate(storyNavigationRoute, navOptions)
}

fun NavGraphBuilder.storyScreen(
    onStoryClick: (Int) -> Unit,
    showCalendar: MutableStateFlow<Boolean>
) {
    composable(
        route = storyNavigationRoute,
    ) {
        StoryRoute(onStoryClick = onStoryClick, showCalendar = showCalendar)
    }
}


fun NavController.navigateToWriteStory(navOptions: NavOptions? = null) {
    this.navigate(storyWriteRoute, navOptions)
}

fun NavGraphBuilder.writeStoryScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = storyWriteRoute,
    ) {

        WriteStoryRoute(
            firstOnBackClick = onBackClick,
        )
    }
}


