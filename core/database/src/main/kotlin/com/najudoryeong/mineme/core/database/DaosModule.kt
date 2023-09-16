package com.najudoryeong.mineme.core.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesHomeDao(
        database: DoDatabase,
    ): HomeDao = database.homeDao()


}