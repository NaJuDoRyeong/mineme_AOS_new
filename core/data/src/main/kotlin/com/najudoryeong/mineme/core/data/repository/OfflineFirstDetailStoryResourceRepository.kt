package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OfflineFirstDetailStoryResourceRepository @Inject constructor(
    private val network: DoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : DetailStoryResourceRepository {

    override fun getDetailStory(storyId: Int): Flow<DetailStoryResource> = flow {
        emit(network.getDetailStory(storyId = storyId).asDomainModel())
    }.flowOn(ioDispatcher)

}