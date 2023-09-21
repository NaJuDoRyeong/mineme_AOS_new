package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import kotlinx.coroutines.flow.Flow

interface StoryResourceRepository {

    // 지역별
    fun getStoryResource(region : String): Flow<StoryRegionResource>

    //캘린더
    fun getCalendarStory(year : String, month : String): Flow<StoryCalendarResource>

}