package com.najudoryeong.mineme.core.network.di

import com.najudoryeong.mineme.core.network.DoNetworkDataSource
import com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FlavoredNetworkModule {
    @Binds
    fun FakeDoNetworkDataSource.binds(): DoNetworkDataSource
}
