package com.najudoryeong.mineme.core.data.test

import com.najudoryeong.mineme.core.data.di.DataModule
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.OfflineFirstHomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.data.repository.fake.FakeHomeResourceRepository
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

    //todo
    @Binds
    fun bindsHomeResourceRepository(
        homeResourceRepository: OfflineFirstHomeResourceRepository
    ): HomeResourceRepository

}