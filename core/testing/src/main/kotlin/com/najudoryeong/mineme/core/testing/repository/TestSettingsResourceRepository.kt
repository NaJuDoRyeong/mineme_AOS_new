package com.najudoryeong.mineme.core.testing.repository

import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestSettingsResourceRepository : SettingsResourceRepository {
    private val codeFlow: MutableSharedFlow<Code> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun sendCode(code: Code) =
        codeFlow.tryEmit(code)

    override fun getCode(): Flow<Code> = codeFlow

}