package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakeHomeResourceRepository @Inject constructor() : HomeResourceRepository {
    override fun getHomeData(): Flow<HomeMainResource> {
        TODO("Not yet implemented")
    }
}