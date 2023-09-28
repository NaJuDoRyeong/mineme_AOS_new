package com.najudoryeong.mineme.feature.story

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
internal fun DetailStoryRoute(
    onBackClick: () -> Unit,
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailStoryViewModel = hiltViewModel(),
) {

    DetailStoryScreen(
        onBackClick = onBackClick,
    )
}

@Composable
fun DetailStoryScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Box(modifier = modifier) {
        Text(text = "detail")
    }

}


