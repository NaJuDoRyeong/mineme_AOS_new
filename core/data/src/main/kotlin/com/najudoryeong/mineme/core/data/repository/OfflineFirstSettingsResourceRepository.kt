package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OfflineFirstSettingsResourceRepository @Inject constructor(
    private val network: DoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : SettingsResourceRepository {
    override fun getCode(): Flow<Code> = flow {
        emit(network.getCode().asDomainModel())
    }.flowOn(ioDispatcher)

}