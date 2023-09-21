package com.najudoryeong.mineme.core.testing.repository

import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
class TestHomeResourceRepository : HomeResourceRepository {

    private val homeResourcesFlow: MutableSharedFlow<HomeMainResource> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    override fun getHomeData(): Flow<HomeMainResource> = homeResourcesFlow

    fun sendHomeResources(homeMainResources: HomeMainResource) {
        homeResourcesFlow.tryEmit(homeMainResources)
    }
}