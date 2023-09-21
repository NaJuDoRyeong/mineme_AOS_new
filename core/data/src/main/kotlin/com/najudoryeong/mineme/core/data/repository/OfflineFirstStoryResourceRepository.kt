package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstStoryResourceRepository @Inject constructor(
    private val network: DoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : StoryResourceRepository {

    override fun getStoryResource(region: String): Flow<StoryRegionResource> {
        TODO("Not yet implemented")
    }

    override fun getCalendarStory(year: String, month: String): Flow<StoryCalendarResource> {
        TODO("Not yet implemented")
    }


}