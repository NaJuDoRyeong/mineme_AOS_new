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

package com.najudoryeong.mineme.core.data.di

import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstDetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstHomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstSettingsResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstUserDataRepository
import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.data.util.ConnectivityManagerNetworkMonitor
import com.najudoryeong.mineme.core.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: OfflineFirstUserDataRepository,
    ): UserDataRepository

    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    fun bindsHomeResourceRepository(
        homeResourceRepository: OfflineFirstHomeResourceRepository,
    ): HomeResourceRepository

    @Binds
    fun bindsStoryResourceRepository(
        homeResourceRepository: OfflineFirstStoryResourceRepository,
    ): StoryResourceRepository

    @Binds
    fun bindsDetailStoryResourceRepository(
        detailStoryResourceRepository: OfflineFirstDetailStoryResourceRepository,
    ): DetailStoryResourceRepository

    @Binds
    fun bindsSettingsResourceRepository(
        settingsResourceRepository: OfflineFirstSettingsResourceRepository,
    ): SettingsResourceRepository
}
