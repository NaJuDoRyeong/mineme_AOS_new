package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.Code
import kotlinx.coroutines.flow.Flow

interface SettingsResourceRepository {
    fun getCode(): Flow<Code>
}