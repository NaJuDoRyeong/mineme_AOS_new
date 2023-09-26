package com.najudoryeong.mineme.core.testing.repository

import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestStoryResourceRepository : StoryResourceRepository {
    private val storyRegionResourceFlow: MutableSharedFlow<StoryRegionResource> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)


    private val storyCalendarResourceFlow: MutableSharedFlow<StoryCalendarResource> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun sendRegionStoryResource(storyRegionResource: StoryRegionResource) =
        storyRegionResourceFlow.tryEmit(storyRegionResource)

    fun sendCalendarStoryResource(storyCalendarResource: StoryCalendarResource) =
        storyCalendarResourceFlow.tryEmit(storyCalendarResource)

    override fun getRegionStory(): Flow<StoryRegionResource> =
        storyRegionResourceFlow

    override fun getCalendarStory(year: String, month: String): Flow<StoryCalendarResource> =
        storyCalendarResourceFlow
}