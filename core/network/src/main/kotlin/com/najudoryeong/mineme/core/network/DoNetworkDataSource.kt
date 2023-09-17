package com.najudoryeong.mineme.core.network

import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource


interface DoNetworkDataSource {
    suspend fun getHomeData(): NetworkHomeMainResource

}



