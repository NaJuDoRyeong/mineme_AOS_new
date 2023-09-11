package com.najudoryeong.mineme.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
) {
    HomeScreen()
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "hi")
    }
}