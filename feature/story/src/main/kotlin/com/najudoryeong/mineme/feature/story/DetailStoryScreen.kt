package com.najudoryeong.mineme.feature.story

import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.designsystem.component.DottedLine
import com.najudoryeong.mineme.core.designsystem.component.ImageSlider
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.ui.DetailStoryUiState


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

        Column {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
            DetailStoryToolBar(onBackClick = onBackClick)

            LazyColumn(modifier = Modifier.fillMaxSize().testTag("detail:posts")) {

                when (detailStoryUiState) {
                    DetailStoryUiState.Loading, DetailStoryUiState.Error -> Unit
                    is DetailStoryUiState.Success -> {
                        items(detailStoryUiState.detailStoryResource.stories) { story ->
                            DetailStoryItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
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
    var isContentExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxHeight()
    ) {

        Text(
            text = location,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = date,
            style = MaterialTheme.typography.bodySmall
        )

        ImageSlider(images = images.map { Uri.parse(it) })

        Text(
            text = content,
            style = MaterialTheme.typography.bodySmall,
            maxLines = if (isContentExpanded) Int.MAX_VALUE else 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .clickable { isContentExpanded = !isContentExpanded }
                .padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = author,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.End
        )

        DottedLine(modifier = Modifier.padding(vertical = 16.dp))
    }
}


@Composable
fun DetailStoryToolBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(id = R.string.story),
            modifier = Modifier.align(Alignment.Center),
        )

        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = DoIcons.ArrowBack,
                contentDescription = stringResource(
                    id = com.najudoryeong.mineme.core.ui.R.string.back,
                ),
            )
        }
    }
}