package com.najudoryeong.mineme.feature.story

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
internal fun StoryRoute(
    modifier: Modifier = Modifier,
) {
    StoryScreen()
}

@Composable
internal fun StoryScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "story")
    }
}