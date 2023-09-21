package com.najudoryeong.mineme.core.network

import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource
import kotlinx.coroutines.flow.Flow


interface DoNetworkDataSource {
    suspend fun getHomeData(): NetworkHomeMainResource

    suspend fun getRegionStory(region : String): NetworkStoryRegionResource

    suspend fun getCalendarStory(year : String, month : String): NetworkStoryCalendarResource

}



