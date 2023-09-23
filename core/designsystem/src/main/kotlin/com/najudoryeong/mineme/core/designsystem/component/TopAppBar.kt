package com.najudoryeong.mineme.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.width
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
            IconButton(onClick = onNavigationClick) {
                Icon(
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
    @StringRes titleRes: Int,
    actionIcon: Int,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
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
