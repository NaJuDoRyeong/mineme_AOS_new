package com.najudoryeong.mineme.feature.story.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.najudoryeong.mineme.feature.story.StoryRoute

const val storyNavigationRoute = "story_route"
fun NavController.navigateToStory(navOptions: NavOptions? = null) {
    this.navigate(storyNavigationRoute, navOptions)
}

fun NavGraphBuilder.storyScreen() {
    composable(
        route = storyNavigationRoute,
    ) {
        StoryRoute()
    }
}
