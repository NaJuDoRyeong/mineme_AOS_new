/*
 * Copyright 2023 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.najudoryeong.mineme.core.testing.repository

import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.model.data.Code
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestSettingsResourceRepository : SettingsResourceRepository {
    private val codeFlow: MutableSharedFlow<Code> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun sendCode(code: Code) =
        codeFlow.tryEmit(code)

    override fun getCode(jwt: String): Flow<Code> = codeFlow
}
