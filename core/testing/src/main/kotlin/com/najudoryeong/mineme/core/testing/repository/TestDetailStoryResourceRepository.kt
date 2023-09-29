package com.najudoryeong.mineme.core.testing.repository

import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestDetailStoryResourceRepository : DetailStoryResourceRepository {

    private val detailStoryResourceFlow: MutableSharedFlow<DetailStoryResource> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun sendDetailStoryResource(detailStoryResource: DetailStoryResource) =
        detailStoryResourceFlow.tryEmit(detailStoryResource)

    override fun getDetailStory(storyId: Int): Flow<DetailStoryResource> = detailStoryResourceFlow

}