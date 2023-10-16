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

package com.najudoryeong.mineme.feature.home

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.testing.repository.TestHomeResourceRepository
import com.najudoryeong.mineme.core.testing.repository.TestUserDataRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import com.najudoryeong.mineme.core.ui.HomeUiState
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val userDataRepository = TestUserDataRepository()
    private val homeResourceRepository = TestHomeResourceRepository()

    private val savedStateHandle = SavedStateHandle()
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(
            savedStateHandle = savedStateHandle,
            userDataRepository = userDataRepository,
            homeResourceRepository = homeResourceRepository,
        )
    }

    // 초기 로딩 상태인지 확인
    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            HomeUiState.Loading,
            viewModel.homeState.value,
        )
    }
}
