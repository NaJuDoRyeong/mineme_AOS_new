package com.najudoryeong.mineme.core.data.model

import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.network.model.NetworkCode

fun NetworkCode.asDomainModel() = Code(
    myCode = myCode,
    mineCode = mineCode
)