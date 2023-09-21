package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OfflineFirstStoryResourceRepository @Inject constructor(
    private val network: DoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : StoryResourceRepository {

    override fun getRegionStory(): Flow<StoryRegionResource> = flow {
        emit(network.getRegionStory().asDomainModel())
    }.flowOn(ioDispatcher)

    override fun getCalendarStory(year: String, month: String): Flow<StoryCalendarResource> = flow {
        emit(network.getCalendarStory(year, month).asDomainModel())
    }.flowOn(ioDispatcher)

}