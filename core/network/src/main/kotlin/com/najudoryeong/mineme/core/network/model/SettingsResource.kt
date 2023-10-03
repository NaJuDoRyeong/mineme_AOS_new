package com.najudoryeong.mineme.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCode(
    val myCode: String,
    val mineCode: String
)

