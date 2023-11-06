/*
 * Copyright 2023 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.model.asDomainModel
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FakeHomeResourceRepository @Inject constructor(
    private val datasource: FakeDoNetworkDataSource,
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : HomeResourceRepository {
    override fun getHomeData(jwt: String): Flow<HomeMainResource> = flow {
        emit(datasource.getHomeData(jwt).asDomainModel())
    }.flowOn(ioDispatcher)
}
