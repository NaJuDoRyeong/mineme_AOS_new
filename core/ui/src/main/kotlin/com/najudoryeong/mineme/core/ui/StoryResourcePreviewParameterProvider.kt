package com.najudoryeong.mineme.core.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.model.data.StoryWithYearMonth


class StoryCalendarResourcePreviewParameterProvider : PreviewParameterProvider<StoryCalendarResource> {
    override val values: Sequence<StoryCalendarResource> = sequenceOf(
        PreviewParameterDataStory.storyCalendarResourceSample
    )
}

class StoryRegionResourcePreviewParameterProvider : PreviewParameterProvider<StoryRegionResource> {
    override val values: Sequence<StoryRegionResource> = sequenceOf(
        PreviewParameterDataStory.storyRegionResource, PreviewParameterDataStory.storyRegionResourceEmpty
    )
}

object PreviewParameterDataStory {
    val postSample1 = Post(
        date = "2023-09-24",
        thumbnail = "https://picsum.photos/200/300",
        postId = 577
    )

    val postSample2 = Post(
        date = "2023-9-24",
        thumbnail = "https://picsum.photos/200/300",
        postId = 578
    )

    val storyWithYearMonthSample = StoryWithYearMonth(
        year = "2022",
        month = "10",
        posts = listOf(postSample1, postSample2)
    )

    val storyCalendarResourceSample = StoryCalendarResource(
        stories = listOf(storyWithYearMonthSample)
    )

    val storyWithRegionSample1 = StoryWithRegion(
        region = "경남",
        city = "창원시",
        posts = listOf(postSample1, postSample2)
    )

    val storyWithRegionSample2 = StoryWithRegion(
        region = "경북",
        city = "경산시",
        posts = listOf(postSample1, postSample2)
    )

    val storyRegionResource = StoryRegionResource(
        stories = listOf(storyWithRegionSample1, storyWithRegionSample2)
    )

    val storyRegionResourceEmpty = StoryRegionResource(
        stories = emptyList()
    )
}
