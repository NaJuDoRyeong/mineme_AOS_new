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

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.najudoryeong.mineme.feature.home.navigation.homeNavigationRoute
import com.najudoryeong.mineme.feature.home.navigation.homeScreen
import com.najudoryeong.mineme.feature.story.navigation.detailStoryScreen
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

        // Story
        storyScreen(
            onStoryClick = navController::navigateToDetailStory,
            showCalendar = appState.shouldShowCalendar,
        ) {
            detailStoryScreen(
                onBackClick = navController::popBackStack,
            )
        }
        writeStoryScreen(
            onBackClick = navController::popBackStack,
        )

        settingsScreen()
    }
}
