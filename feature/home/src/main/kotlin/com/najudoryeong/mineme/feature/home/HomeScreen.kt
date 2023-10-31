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

package com.najudoryeong.mineme.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.ui.DottedLine
import com.najudoryeong.mineme.core.designsystem.component.DynamicAsyncImage
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.model.data.Couple
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.NewStory
import com.najudoryeong.mineme.core.model.data.Person
import com.najudoryeong.mineme.core.ui.HomeMainResourcePreviewParameterProvider
import com.najudoryeong.mineme.core.ui.HomeUiState

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    HomeScreen(
        homeState = homeState,
        modifier = modifier,
    )
}

@Composable
internal fun HomeScreen(
    homeState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    val isHomeLoading = homeState is HomeUiState.Loading

    // TODO REPORT
    // ReportDrawnWhen { !isSyncing && !isOnboardingLoading && !isFeedLoading }

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                when (homeState) {
                    is HomeUiState.Success -> {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier,
                        ) {
                            CoupleProfile(
                                modifier = Modifier,
                                couple = homeState.homeMainResource.couple,
                            )
                        }

                        DottedLine(Modifier.padding(vertical = 16.dp, horizontal = 32.dp))

                        CurrentStory(newStory = homeState.homeMainResource.newStory)
                    }
                    HomeUiState.Loading -> Unit
                }
            }
        }

        AnimatedVisibility(
            visible = isHomeLoading,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight },
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
            ) + fadeOut(),
        ) {
            val loadingContentDescription = stringResource(id = R.string.home_loading)
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
fun CurrentStory(
    modifier: Modifier = Modifier,
    newStory: NewStory,
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (newStory.thumbnailImage == "") {
            Text(
                text = stringResource(R.string.no_story),
                style = MaterialTheme.typography.titleMedium,
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(16.dp),
                painter = painterResource(id = DoIcons.no_story.resourceId),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.no_story2),
                style = MaterialTheme.typography.bodyMedium,
            )
        } else {
            Text(text = stringResource(R.string.new_story))
            DynamicAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                imageUrl = newStory.thumbnailImage,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun CoupleProfile(
    modifier: Modifier,
    couple: Couple,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Profile(
            profileInfo = couple.me,
            defaultIcon = DoIcons.default_me.resourceId,
        )

        Icon(
            modifier = Modifier.padding(top = 80.dp),
            painter = painterResource(id = DoIcons.heart.resourceId),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Profile(
            profileInfo = couple.mine,
            defaultIcon = DoIcons.default_mine.resourceId,
        )
    }
}

@Composable
fun Profile(
    profileInfo: Person,
    modifier: Modifier = Modifier,
    defaultIcon: Int,
) {
    Column(
        modifier = modifier.width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp),
            profileImgUrl = profileInfo.profileImage,
            defaultIcon = defaultIcon,
        )

        Text(
            text = profileInfo.nickname,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )

        val description =
            profileInfo.description.ifEmpty { stringResource(R.string.empty_description) }

        Text(
            text = description,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )

        if (profileInfo.instaId.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = profileInfo.instaId,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    profileImgUrl: String,
    defaultIcon: Int,
    profileTag: String = "CoupleProfile:Image",

) {
    if (profileImgUrl.isEmpty()) {
        Icon(
            modifier = modifier.testTag(profileTag),
            painter = painterResource(id = defaultIcon),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    } else {
        DynamicAsyncImage(
            modifier = modifier,
            imageUrl = profileImgUrl,
            contentDescription = null,
            completeTag = profileTag,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenSuccessPreview(
    @PreviewParameter(HomeMainResourcePreviewParameterProvider::class)
    homeMainResource: HomeMainResource,
) {
    DoTheme {
        HomeScreen(
            homeState = HomeUiState.Success(
                homeMainResource = homeMainResource,
            ),
        )
    }
}

@Preview
@Composable
fun HomeScreenLoadingPreview(
    @PreviewParameter(HomeMainResourcePreviewParameterProvider::class)
    homeMainResource: HomeMainResource,
) {
    DoTheme {
        HomeScreen(
            homeState = HomeUiState.Loading,
        )
    }
}
