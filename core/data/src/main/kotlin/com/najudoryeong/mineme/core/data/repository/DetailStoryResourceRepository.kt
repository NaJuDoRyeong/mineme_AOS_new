package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import kotlinx.coroutines.flow.Flow

interface DetailStoryResourceRepository {
    fun getDetailStory(storyId : Int): Flow<DetailStoryResource>

}