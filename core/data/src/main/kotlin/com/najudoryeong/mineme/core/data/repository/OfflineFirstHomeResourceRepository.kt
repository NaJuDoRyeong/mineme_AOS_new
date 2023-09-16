package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.database.dao.HomeDao
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstHomeResourceRepository @Inject constructor(
    private val homeDao: HomeDao,
    private val network: DoNetworkDataSource,
) : HomeResourceRepository{
    override fun observeAll(): Flow<List<HomeMainResource>> = homeRepository.getHomeResource()

}