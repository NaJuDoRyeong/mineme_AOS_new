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

package com.najudoryeong.mineme.core.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.model.data.StoryWithYearMonth

class StoryCalendarResourcePreviewParameterProvider : PreviewParameterProvider<StoryCalendarResource> {
    override val values: Sequence<StoryCalendarResource> = sequenceOf(
        PreviewParameterDataStory.storyCalendarResourceSample,
    )
}

class StoryRegionResourcePreviewParameterProvider : PreviewParameterProvider<StoryRegionResource> {
    override val values: Sequence<StoryRegionResource> = sequenceOf(
        PreviewParameterDataStory.storyRegionResource,
        PreviewParameterDataStory.storyRegionResourceEmpty,
    )
}

object PreviewParameterDataStory {
    val postSample1 = Post(
        date = "2023-09-24",
        thumbnail = "https://picsum.photos/1000/1000",
        postId = 577,
    )

    val postSample2 = Post(
        date = "2023-9-24",
        thumbnail = "https://picsum.photos/1000/1000",
        postId = 578,
    )

    val storyWithYearMonthSample = StoryWithYearMonth(
        year = "2022",
        month = "10",
        posts = listOf(postSample1, postSample2),
    )

    val storyCalendarResourceSample = StoryCalendarResource(
        stories = listOf(storyWithYearMonthSample),
    )

    val storyWithRegionSample1 = StoryWithRegion(
        region = "경남",
        city = "창원시",
        posts = listOf(postSample1, postSample2),
    )

    val storyWithRegionSample2 = StoryWithRegion(
        region = "경북",
        city = "경산시",
        posts = listOf(postSample1, postSample2),
    )

    val storyRegionResource = StoryRegionResource(
        stories = listOf(storyWithRegionSample1, storyWithRegionSample2),
    )

    val storyRegionResourceEmpty = StoryRegionResource(
        stories = emptyList(),
    )
}
