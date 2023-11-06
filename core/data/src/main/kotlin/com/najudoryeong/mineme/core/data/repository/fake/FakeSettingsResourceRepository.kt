package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FakeSettingsResourceRepository @Inject constructor(
    private val datasource: FakeDoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : SettingsResourceRepository{
    override fun getCode(jwt: String): Flow<Code> = flow {
        emit(datasource.getCode(jwt).asDomainModel())
    }.flowOn(ioDispatcher)


}