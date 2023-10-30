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

package com.najudoryeong.mineme.core.network

import com.najudoryeong.mineme.core.network.model.NetworkCode
import com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource

interface DoNetworkDataSource {
    suspend fun getHomeData(): NetworkHomeMainResource

    suspend fun getRegionStory(): NetworkStoryRegionResource

    suspend fun getCalendarStory(year: String, month: String): NetworkStoryCalendarResource

    suspend fun getDetailStory(storyId: Int): NetworkDetailStoryResource

    suspend fun getCode(): NetworkCode
}
