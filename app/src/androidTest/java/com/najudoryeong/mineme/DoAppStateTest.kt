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

package com.najudoryeong.mineme

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import com.najudoryeong.mineme.core.testing.util.TestNetworkMonitor
import com.najudoryeong.mineme.ui.DoAppState
import com.najudoryeong.mineme.ui.rememberDoAppState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class DoAppStateTest {

    // 테스트를 위한 규칙 정의
    @get:Rule
    val composeTestRule = createComposeRule()

    private val networkMonitor = TestNetworkMonitor()

    // 테스트 대상
    private lateinit var state: DoAppState

    // AppState currentDestination이 잘 동작하는지
    @Test
    fun doAppState_currentDestination() = runTest {
        var currentDestination: String? = null

        composeTestRule.setContent {
            val navController = rememberTestNavController()
            state = remember(navController) {
                DoAppState(
                    navController = navController,
                    coroutineScope = backgroundScope,
                    windowSizeClass = getCompactWindowClass(),
                    networkMonitor = networkMonitor,
                )
            }

            currentDestination = state.currentDestination?.route

            LaunchedEffect(Unit) {
                navController.setCurrentDestination("b")
            }
        }

        assertEquals("b", currentDestination)
    }

    // toLevelDestination이 올바른 개수,순서인지
    @Test
    fun doAppState_destinations() = runTest {
        composeTestRule.setContent {
            state = rememberDoAppState(
                windowSizeClass = getCompactWindowClass(),
                networkMonitor = networkMonitor,
            )
        }

        assertEquals(3, state.topLevelDestinations.size)
        assertTrue(state.topLevelDestinations[0].name.contains("home", true))
        assertTrue(state.topLevelDestinations[1].name.contains("story", true))
        assertTrue(state.topLevelDestinations[2].name.contains("settings", true))
    }

    @Test
    fun doAppState_showBottomBar_compact() = runTest {
        composeTestRule.setContent {
            state = DoAppState(
                navController = NavHostController(LocalContext.current),
                coroutineScope = backgroundScope,
                windowSizeClass = getCompactWindowClass(),
                networkMonitor = networkMonitor,
            )
        }

        assertTrue(state.shouldShowBottomBar)
    }

    // offline 설정 잘 되는지
    @Test
    fun stateIsOfflineWhenNetworkMonitorIsOffline() = runTest(UnconfinedTestDispatcher()) {
        composeTestRule.setContent {
            state = DoAppState(
                navController = NavHostController(LocalContext.current),
                coroutineScope = backgroundScope,
                windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(900.dp, 1200.dp)),
                networkMonitor = networkMonitor,
            )
        }

        backgroundScope.launch { state.isOffline.collect() }
        networkMonitor.setConnected(false)
        assertEquals(
            true,
            state.isOffline.value,
        )
    }

    private fun getCompactWindowClass() = WindowSizeClass.calculateFromSize(DpSize(500.dp, 300.dp))
}

// TestNavHostController 설정
@Composable
private fun rememberTestNavController(): TestNavHostController {
    val context = LocalContext.current
    return remember {
        TestNavHostController(context).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            graph = createGraph(startDestination = "a") {
                composable("a") { }
                composable("b") { }
                composable("c") { }
            }
        }
    }
}
