package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.flow.Flow

interface StoryResourceRepository {

    // 지역별
    fun getRegionStory(): Flow<HomeMainResource>


    //캘린더
    fun getCalendarStory(): Flow<HomeMainResource>


}