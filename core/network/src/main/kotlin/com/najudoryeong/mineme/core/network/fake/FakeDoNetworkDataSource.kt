package com.najudoryeong.mineme.core.network.fake

import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.JvmUnitTestFakeAssetManager
import com.najudoryeong.mineme.core.network.model.NetworkChangeList
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.nowinandroid.core.network.Dispatcher
import com.najudoryeong.mineme.nowinandroid.core.network.DoDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class FakeDoNetworkDataSource @Inject constructor(
    @Dispatcher(DoDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : DoNetworkDataSource {


    companion object {
        private const val HOME_ASSET = "home.json"
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getHomeData(): NetworkHomeMainResource =
        withContext(ioDispatcher) {
            assets.open(HOME_ASSET).use(networkJson::decodeFromStream)
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
