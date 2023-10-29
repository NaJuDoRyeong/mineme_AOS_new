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

package com.najudoryeong.mineme.feature.settings

import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.testing.repository.TestSettingsResourceRepository
import com.najudoryeong.mineme.core.testing.repository.TestUserDataRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import com.najudoryeong.mineme.core.ui.AccountUiState
import com.najudoryeong.mineme.feature.story.SettingsUiState
import com.najudoryeong.mineme.feature.story.SettingsViewModel
import com.najudoryeong.mineme.feature.story.UserEditableSettings
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SettingsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val settingsResourceRepository = TestSettingsResourceRepository()
    private val userDataRepository = TestUserDataRepository()
    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        viewModel = SettingsViewModel(
            settingsResourceRepository = settingsResourceRepository,
            userDataRepository = userDataRepository,
        )
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(AccountUiState.Loading, viewModel.accountState.value)
    }

    @Test
    fun testAccountState() = runTest {
        val collectJob1 = launch(UnconfinedTestDispatcher()) { viewModel.accountState.collect() }

        settingsResourceRepository.sendCode(sampleCode)

        val state = viewModel.accountState.value
        assertTrue(state is AccountUiState.Success)
        assertEquals(sampleCode, state.code)

        collectJob1.cancel()
    }

    @Test
    fun stateIsSuccessAfterUserDataLoaded() = runTest {
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.settingsUiState.collect() }
        userDataRepository.setDarkThemeConfig(DarkThemeConfig.DARK)
        assertEquals(
            SettingsUiState.Success(
                UserEditableSettings(
                    darkThemeConfig = DarkThemeConfig.DARK,
                    useDynamicColor = false,
                ),
            ),
            viewModel.settingsUiState.value,
        )

        collectJob.cancel()
    }

    private val sampleCode = Code(
        myCode = "test_my_code",
        mineCode = "test_mine_code",
    )
}
