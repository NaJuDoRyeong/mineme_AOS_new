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
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.designsystem.component.Separator
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.ui.AccountUiState
import com.najudoryeong.mineme.feature.settings.R

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val accountState by viewModel.accountState.collectAsStateWithLifecycle()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SETTINGS_MAIN_ROUTE) {
        composable(SETTINGS_MAIN_ROUTE) {
            SettingsScreen(
                modifier = modifier,
                titleRes = R.string.settings,
                navController = navController,
            )
        }
        composable(SETTINGS_ACCOUNT_ROUTE) {
            AccountScreen(
                modifier = modifier,
                titleRes = R.string.Account,
                accountState = accountState,
            )
        }
    }
}

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int = R.string.Account,
    accountState: AccountUiState,
) {
    val isAccountLoading = accountState is AccountUiState.Loading
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        when (accountState) {
            AccountUiState.Loading -> Unit
            is AccountUiState.Success -> {
                SubAccount(accountState.code)
                SubAccountManagement()
            }
        }
    }

    AnimatedVisibility(
        visible = isAccountLoading,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -fullHeight },
        ) + fadeIn(),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> -fullHeight },
        ) + fadeOut(),
    ) {
        val loadingContentDescription = stringResource(R.string.account_loading)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            DoOverlayLoadingWheel(
                modifier = Modifier
                    .align(Alignment.Center),
                contentDesc = loadingContentDescription,
            )
        }
    }
}

@Composable
internal fun SubAccount(
    code: Code,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "계정",
            style = MaterialTheme.typography.labelMedium,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "나의 코드",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = code.myCode,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Separator()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "상대 코드",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = code.mineCode,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Separator()
    }
}

@Composable
internal fun SubAccountManagement(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "계정관리",
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "로그아웃",
            style = MaterialTheme.typography.bodyLarge,
        )
        Separator()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "계정 탈퇴",
            style = MaterialTheme.typography.bodyLarge,
        )
        Separator()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    @StringRes titleRes: Int = R.string.settings,
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
