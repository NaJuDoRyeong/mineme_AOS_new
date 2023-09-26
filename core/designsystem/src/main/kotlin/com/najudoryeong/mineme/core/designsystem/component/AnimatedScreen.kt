package com.najudoryeong.mineme.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable


@Composable
fun AnimatedScreen(isVisible: Boolean, content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(initialOffsetX = { 500 }, animationSpec = tween(durationMillis = 1000)),
        exit = slideOutHorizontally(targetOffsetX = { -500 }, animationSpec = tween(durationMillis = 1000))
    ) {
        content()
    }
}
