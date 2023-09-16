package com.najudoryeong.mineme.core.data.repository


import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.nowinandroid.core.network.Dispatcher
import com.najudoryeong.mineme.nowinandroid.core.network.DoDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OfflineFirstHomeResourceRepository @Inject constructor(
    private val network: DoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : HomeResourceRepository {

    override fun getHomeData(): Flow<HomeMainResource> = network.getHomeData()

}
