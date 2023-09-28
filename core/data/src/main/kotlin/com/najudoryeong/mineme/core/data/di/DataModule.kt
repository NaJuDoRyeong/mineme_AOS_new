package com.najudoryeong.mineme.core.data.di

import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstDetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstHomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstUserDataRepository
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
        homeResourceRepository: OfflineFirstHomeResourceRepository
    ): HomeResourceRepository

    @Binds
    fun bindsStoryResourceRepository(
        homeResourceRepository: OfflineFirstStoryResourceRepository
    ): StoryResourceRepository

    @Binds
    fun bindsDetailStoryResourceRepository(
        detailStoryResourceRepository: OfflineFirstDetailStoryResourceRepository
    ): DetailStoryResourceRepository

}