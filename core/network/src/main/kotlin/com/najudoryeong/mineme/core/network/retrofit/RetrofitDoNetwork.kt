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

package com.najudoryeong.mineme.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.najudoryeong.mineme.core.network.BuildConfig
import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.model.NetworkCode
import com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitDoNetworkApi {
    @GET("api/test/main/info")
    suspend fun getHomeMainResource(
        @Header("Authorization") token: String,
    ): NetworkResponse<NetworkHomeMainResource>

    @GET("api/v1/stories/location")
    suspend fun getRegionStory(
        @Header("Authorization") token: String,
    ): NetworkResponse<NetworkStoryRegionResource>

    @GET("api/v1/stories/calendar")
    suspend fun getCalendarStory(
        @Header("Authorization") token: String,
        @Query("year") year: String,
        @Query("month") month: String,
    ): NetworkResponse<NetworkStoryCalendarResource>

    @GET("api/v1/stories/{storyId}")
    suspend fun getDetailStory(
        @Header("Authorization") token: String,
        @Path("storyId") storyId: Int,
    ): NetworkResponse<NetworkDetailStoryResource>

    @GET("api/v1/settings/code")
    suspend fun getCode(
        @Header("Authorization") token: String,
    ): NetworkResponse<NetworkCode>
}

private const val DO_BASE_URL = BuildConfig.BACKEND_URL

@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

@Singleton
class RetrofitDoNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : DoNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(DO_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitDoNetworkApi::class.java)

    override suspend fun getHomeData(jwt: String): NetworkHomeMainResource =
        networkApi.getHomeMainResource(token = jwt).data

    override suspend fun getRegionStory(jwt: String): NetworkStoryRegionResource =
        networkApi.getRegionStory(token = jwt).data

    override suspend fun getCalendarStory(
        jwt: String,
        year: String,
        month: String,
    ): NetworkStoryCalendarResource =
        networkApi.getCalendarStory(token = jwt, year = year, month = month).data

    override suspend fun getDetailStory(jwt: String, storyId: Int): NetworkDetailStoryResource =
        networkApi.getDetailStory(token = jwt, storyId = storyId).data

    override suspend fun getCode(jwt: String): NetworkCode =
        networkApi.getCode(token = jwt).data
}
