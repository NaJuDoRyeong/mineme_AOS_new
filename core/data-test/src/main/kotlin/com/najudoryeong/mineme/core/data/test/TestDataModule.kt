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

package com.najudoryeong.mineme.core.data.test

import com.najudoryeong.mineme.core.data.di.DataModule
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstDetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstSettingsResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeDetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeHomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeSettingsResourceRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeUserDataRepository
import com.najudoryeong.mineme.core.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class],
)
interface TestDataModule {

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: FakeUserDataRepository,
    ): UserDataRepository

    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: AlwaysOnlineNetworkMonitor,
    ): NetworkMonitor

    // todo
    @Binds
    fun bindsHomeResourceRepository(
        homeResourceRepository: FakeHomeResourceRepository,
    ): HomeResourceRepository

    @Binds
    fun bindsStoryResourceRepository(
        storyResourceRepository: FakeStoryResourceRepository,
    ): StoryResourceRepository

    @Binds
    fun bindsDetailStoryResourceRepository(
        detailStoryResourceRepository: FakeDetailStoryResourceRepository,
    ): DetailStoryResourceRepository

    @Binds
    fun bindsSettingsResourceRepository(
        settingsResourceRepository: FakeSettingsResourceRepository,
    ): SettingsResourceRepository
}
