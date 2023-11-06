package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class FakeStoryResourceRepository @Inject constructor(
    private val datasource: FakeDoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : StoryResourceRepository{
    override fun getRegionStory(jwt: String): Flow<StoryRegionResource> = flow {
        emit(datasource.getRegionStory(jwt).asDomainModel())
    }.flowOn(ioDispatcher)

    override fun getCalendarStory(
        jwt: String,
        year: String,
        month: String,
    ): Flow<StoryCalendarResource> = flow {
        emit(datasource.getCalendarStory(jwt,year, month).asDomainModel())
    }.flowOn(ioDispatcher)
}