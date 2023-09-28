package com.najudoryeong.mineme.feature.story

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel


@Composable
internal fun DetailStoryRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    viewModel: DetailStoryViewModel = hiltViewModel(),
) {

    val detailStoryUiState by viewModel.detailStoryUiState.collectAsStateWithLifecycle()

    DetailStoryScreen(
        onBackClick = onBackClick,
        detailStoryUiState = detailStoryUiState
    )
}

@Composable
fun DetailStoryScreen(
    modifier: Modifier = Modifier,
    detailStoryUiState: DetailStoryUiState,
    onBackClick: () -> Unit,
) {

    val isDetailLoading = detailStoryUiState is DetailStoryUiState.Loading

    Box(modifier = modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            when (detailStoryUiState) {
                DetailStoryUiState.Loading, DetailStoryUiState.Error -> Unit
                is DetailStoryUiState.Success -> {
                    items(detailStoryUiState.detailStoryResource.stories) { story ->
                        DetailStoryItem(
                            modifier = Modifier.fillMaxWidth(),
                            location = "${story.region}  ${story.city}",
                            date = story.date,
                            images = story.images,
                            content = story.content,
                            author = story.author,
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = isDetailLoading,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight },
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
            ) + fadeOut(),
        ) {
            val loadingContentDescription = stringResource(R.string.detail_story_loading)
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
}

@Composable
fun DetailStoryItem(
    modifier: Modifier = Modifier,
    location: String,
    date: String,
    images: List<String>,
    content: String,
    author: String
) {

    Column(
        modifier = modifier
    ) {

        Text(
            text = location,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = date,
            style = MaterialTheme.typography.bodySmall
        )




    }

}
