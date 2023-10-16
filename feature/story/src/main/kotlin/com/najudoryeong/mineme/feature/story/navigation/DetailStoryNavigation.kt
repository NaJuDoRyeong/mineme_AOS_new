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

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.najudoryeong.mineme.feature.story.DetailStoryRoute
import java.net.URLDecoder
import java.net.URLEncoder

private val URL_CHARACTER_ENCODING = Charsets.UTF_8.name()

@VisibleForTesting
internal const val storyArg = "storyId"

internal class StoryArgs(val storyId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(
            URLDecoder.decode(
                checkNotNull(savedStateHandle[storyArg]),
                URL_CHARACTER_ENCODING,
            ),
        )
}

fun NavController.navigateToDetailStory(storyId: Int) {
    val encodedId = URLEncoder.encode(storyId.toString(), URL_CHARACTER_ENCODING)
    this.navigate("story_route/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.detailStoryScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = "story_route/{$storyArg}",
        arguments = listOf(
            navArgument(storyArg) { type = NavType.StringType },
        ),
    ) {
        DetailStoryRoute(
            onBackClick = onBackClick,
        )
    }
}
