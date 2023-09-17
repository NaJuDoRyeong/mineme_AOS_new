package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.data.Syncable
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.flow.Flow

interface HomeResourceRepository{
    fun getHomeData(): Flow<HomeMainResource>
}