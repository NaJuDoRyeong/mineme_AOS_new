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

package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.data.model.asDomainModel
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

    override fun getRegionStory(jwt: String): Flow<StoryRegionResource> = flow {
        emit(network.getRegionStory(jwt).asDomainModel())
    }.flowOn(ioDispatcher)

    override fun getCalendarStory(
        jwt: String,
        year: String,
        month: String,
    ): Flow<StoryCalendarResource> = flow {
        emit(network.getCalendarStory(jwt, year, month).asDomainModel())
    }.flowOn(ioDispatcher)
}
