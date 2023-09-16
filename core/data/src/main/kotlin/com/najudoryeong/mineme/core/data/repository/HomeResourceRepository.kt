package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.flow.Flow

interface HomeResourceRepository {
    fun observeAll(): Flow<List<HomeMainResource>>

}