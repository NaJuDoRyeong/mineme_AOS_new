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

package com.najudoryeong.mineme.feature.story.navigation

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
    showCalendar: MutableStateFlow<Boolean>,
    nestedGraphs: () -> Unit,
) {
    composable(
        route = storyNavigationRoute,
    ) {
        StoryRoute(onStoryClick = onStoryClick, showCalendar = showCalendar)
    }

    nestedGraphs()
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
