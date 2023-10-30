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

package com.najudoryeong.mineme.feature.story

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.najudoryeong.mineme.core.designsystem.component.Separator
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.feature.settings.R

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val settingsUiState by viewModel.settingsUiState.collectAsStateWithLifecycle()
    val accountState by viewModel.accountState.collectAsStateWithLifecycle()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SETTINGS_MAIN_ROUTE) {
        composable(SETTINGS_MAIN_ROUTE) {
            SettingsScreen(
                modifier = modifier,
                navController = navController,
            )
        }
        composable(SETTINGS_ACCOUNT_ROUTE) {
            AccountScreen(
                modifier = modifier,
                accountState = accountState,
            )
        }

        composable(SETTINGS_THEME_ROUTE) {
            ThemeScreen(
                modifier = modifier,
                settingsUiState = settingsUiState,
                onChangeDynamicColorPreference = viewModel::updateDynamicColorPreference,
                onChangeDarkThemeConfig = viewModel::updateDarkThemeConfig,
            )
        }
    }
}

@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.Account,
            navigateTo = { navController.navigate(SETTINGS_ACCOUNT_ROUTE) },
        )

        SettingsItem(
            iconRes = DoIcons.setting_notification.resourceId,
            descriptionRes = R.string.notification,
            navigateTo = {},
        )

        SettingsItem(
            iconRes = DoIcons.setting_security.resourceId,
            descriptionRes = R.string.security,
            navigateTo = {},
        )

        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.announcement,
            navigateTo = {},
        )

        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.contact,
            navigateTo = {},
        )

        SettingsItem(
            iconRes = DoIcons.settings.resourceId,
            descriptionRes = R.string.theme,
            navigateTo = { navController.navigate(SETTINGS_THEME_ROUTE) },
        )
    }
}

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int = DoIcons.setting_default.resourceId,
    @StringRes descriptionRes: Int,
    navigateTo: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = navigateTo),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = stringResource(id = descriptionRes))
    }
    Separator()
}

const val SETTINGS_MAIN_ROUTE = "settings_main"
const val SETTINGS_ACCOUNT_ROUTE = "settings_account"
const val SETTINGS_NOTIFICATION_ROUTE = "settings_notification"
const val SETTINGS_SECURITY_ROUTE = "settings_security"
const val SETTINGS_ANNOUNCEMENT_ROUTE = "settings_announcement"
const val SETTINGS_CONTACT_ROUTE = "settings_contact"
const val SETTINGS_THEME_ROUTE = "settings_theme"
