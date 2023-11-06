package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FakeDetailStoryResourceRepository @Inject constructor(
    private val datasource: FakeDoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : DetailStoryResourceRepository {
    override fun getDetailStory(jwt: String, storyId: Int): Flow<DetailStoryResource> = flow {
        emit(
            datasource.getDetailStory(jwt = jwt, storyId = storyId).asDomainModel(),
        )
    }.flowOn(ioDispatcher)

}