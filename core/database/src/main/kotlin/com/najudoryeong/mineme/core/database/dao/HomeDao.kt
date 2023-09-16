package com.najudoryeong.mineme.core.database.dao

import androidx.room.Query
import com.najudoryeong.mineme.core.database.model.HomeMainResourceEntity
import kotlinx.coroutines.flow.Flow

interface HomeDao {
    @Query(value = "SELECT * FROM HomeMainResource")
    fun getHomeMainResource(): Flow<HomeMainResourceEntity>



}