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

package com.najudoryeong.mineme.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
왼쪽 Navigation 있는 TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: Int,
    navigationIconContentDescription: String?,
    actionIcon: Int,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(modifier = Modifier.size(60.dp), onClick = onNavigationClick) {
                Icon(
                    modifier = Modifier.testTag("Story:ChangeView"),
                    painter = painterResource(id = navigationIcon),
                    contentDescription = navigationIconContentDescription,
                    tint = Color.Unspecified,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = painterResource(id = actionIcon),
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("DoTopAppBar"),
    )
}

/**
왼쪽 Navigation 없는 TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoTopAppBar(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    actionIcon: Int = -1,
    actionIconContentDescription: String?,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        actions = {
            if (actionIcon != -1) {
                IconButton(onClick = onActionClick) {
                    Icon(
                        painter = painterResource(id = actionIcon),
                        contentDescription = actionIconContentDescription,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
        colors = colors,
        modifier = modifier.testTag("DoTopAppBar"),
    )
}
