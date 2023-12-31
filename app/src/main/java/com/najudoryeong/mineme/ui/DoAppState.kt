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

package com.najudoryeong.mineme.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.najudoryeong.mineme.core.data.util.NetworkMonitor
import com.najudoryeong.mineme.feature.home.navigation.homeNavigationRoute
import com.najudoryeong.mineme.feature.home.navigation.navigateToHome
import com.najudoryeong.mineme.feature.story.navigation.navigateToSettings
import com.najudoryeong.mineme.feature.story.navigation.navigateToStory
import com.najudoryeong.mineme.feature.story.navigation.navigateToWriteStory
import com.najudoryeong.mineme.feature.story.navigation.settingsNavigationRoute
import com.najudoryeong.mineme.feature.story.navigation.storyNavigationRoute
import com.najudoryeong.mineme.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberDoAppState(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): DoAppState {
    return remember(
        navController,
        coroutineScope,
        windowSizeClass,
        networkMonitor,
    ) {
        DoAppState(
            navController,
            coroutineScope,
            windowSizeClass,
            networkMonitor,
        )
    }
}

@Stable
class DoAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeNavigationRoute -> TopLevelDestination.Home
            storyNavigationRoute -> TopLevelDestination.Story
            settingsNavigationRoute -> TopLevelDestination.Settings
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowCalendar: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun updateShowCalendar() {
        shouldShowCalendar.value = !shouldShowCalendar.value
    }

    fun navigateToWriteStory() {
        navController.navigateToWriteStory()
    }

    /**
     trace 함수는 특정 작업의 성능 추적을 수행하기 위해 사용
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // 현재 네비게이션 스택에서 시작 목적지까지 모든 목적지를 팝
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            // 이미 스택의 상위에 동일한 목적지가 있는 경우, 새 목적지 인스턴스를 시작하지 않고 기존 인스턴스를 재사용
            launchSingleTop = true
            // 이전에 선택한 항목을 다시 선택할 때 상태를 복원
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.Home -> navController.navigateToHome(topLevelNavOptions)
            TopLevelDestination.Story -> navController.navigateToStory(topLevelNavOptions)
            TopLevelDestination.Settings -> navController.navigateToSettings(topLevelNavOptions)
        }
    }
}
