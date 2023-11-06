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

package com.najudoryeong.mineme.core.network.fake

import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.JvmUnitTestFakeAssetManager
import com.najudoryeong.mineme.core.network.model.NetworkCode
import com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import okio.use
import javax.inject.Inject

@OptIn(ExperimentalSerializationApi::class)
class FakeDoNetworkDataSource @Inject constructor(
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : DoNetworkDataSource {

    companion object {
        private const val HOME_ASSET = "home.json"
        private const val StoryRegion_ASSET = "story_region.json"
        private const val StoryCalendar_ASSET = "story_calendar.json"
        private const val DetailStory_ASSET = "detail_story.json"
        private const val CODE_ASSET = "code.json"
    }

    // 애셋을 josn으로 디코딩
    override suspend fun getHomeData(jwt: String): NetworkHomeMainResource =
        withContext(ioDispatcher) {
            assets.open(HOME_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getRegionStory(jwt: String): NetworkStoryRegionResource =
        withContext(ioDispatcher) {
            assets.open(StoryRegion_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getCalendarStory(
        jwt: String,
        year: String,
        month: String,
    ): NetworkStoryCalendarResource =
        withContext(ioDispatcher) {
            assets.open(StoryCalendar_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getDetailStory(jwt: String,storyId: Int): NetworkDetailStoryResource =
        withContext(ioDispatcher) {
            assets.open(DetailStory_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getCode(jwt: String): NetworkCode =
        withContext(ioDispatcher) {
            assets.open(CODE_ASSET).use(networkJson::decodeFromStream)
        }
}
