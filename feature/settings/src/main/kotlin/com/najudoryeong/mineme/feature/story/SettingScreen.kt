package com.najudoryeong.mineme.feature.story

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    Box(modifier.fillMaxSize()) {
        Text(text = "setting")
    }
}