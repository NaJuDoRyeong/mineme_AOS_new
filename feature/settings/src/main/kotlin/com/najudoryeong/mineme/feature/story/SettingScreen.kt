package com.najudoryeong.mineme.feature.story

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.najudoryeong.mineme.core.designsystem.component.DottedLine
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.feature.settings.R

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
) {
    SettingsScreen()
}


@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier
) {


    Column(modifier.fillMaxSize()) {
        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.Account,
            navigateTo = {}
        )

        SettingsItem(
            iconRes = DoIcons.setting_notification.resourceId,
            descriptionRes = R.string.notification,
            navigateTo = {}
        )

        SettingsItem(
            iconRes = DoIcons.setting_security.resourceId,
            descriptionRes = R.string.security,
            navigateTo = {}
        )

        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.announcement,
            navigateTo = {}
        )

        SettingsItem(
            iconRes = DoIcons.setting_default.resourceId,
            descriptionRes = R.string.contact,
            navigateTo = {}
        )
    }

}


@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int = DoIcons.setting_default.resourceId,
    @StringRes descriptionRes: Int,
    navigateTo: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = stringResource(id = descriptionRes))
    }
}

