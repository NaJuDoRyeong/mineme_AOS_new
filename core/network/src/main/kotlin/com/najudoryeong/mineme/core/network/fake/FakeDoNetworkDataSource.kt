package com.najudoryeong.mineme.core.network.fake

import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.JvmUnitTestFakeAssetManager
import com.najudoryeong.mineme.core.network.model.NetworkChangeList
import com.najudoryeong.mineme.core.network.Dispatcher
import com.najudoryeong.mineme.core.network.DoDispatchers
import com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource
import okio.use
import javax.inject.Inject

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
    }


    // 애셋을 josn으로 디코딩
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getHomeData(): NetworkHomeMainResource =
        withContext(ioDispatcher) {
            assets.open(HOME_ASSET).use(networkJson::decodeFromStream)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getRegionStory(): NetworkStoryRegionResource =
        withContext(ioDispatcher) {
            assets.open(StoryRegion_ASSET).use(networkJson::decodeFromStream)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCalendarStory(
        year: String,
        month: String
    ): NetworkStoryCalendarResource =
        withContext(ioDispatcher) {
            assets.open(StoryCalendar_ASSET).use(networkJson::decodeFromStream)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getDetailStory(storyId: Int): NetworkDetailStoryResource =
        withContext(ioDispatcher) {
            assets.open(DetailStory_ASSET).use(networkJson::decodeFromStream)
        }
}

/**
 * Converts a list of [T] to change list of all the items in it where [idGetter] defines the
 * [NetworkChangeList.id]
 */
private fun <T> List<T>.mapToChangeList(
    idGetter: (T) -> String,
) = mapIndexed { index, item ->
    NetworkChangeList(
        id = idGetter(item),
        changeListVersion = index,
        isDelete = false,
    )
}
