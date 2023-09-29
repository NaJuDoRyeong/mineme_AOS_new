package com.najudoryeong.mineme.feature.settings

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.model.data.Anniversary
import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.model.data.DetailStory
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.testing.repository.TestDetailStoryResourceRepository
import com.najudoryeong.mineme.core.testing.repository.TestSettingsResourceRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import com.najudoryeong.mineme.core.ui.AccountUiState
import com.najudoryeong.mineme.core.ui.DetailStoryUiState
import com.najudoryeong.mineme.feature.story.SettingsViewModel
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

    private lateinit var viewModel: SettingsViewModel


    @Before
    fun setup() {
        viewModel = SettingsViewModel(
            settingsResourceRepository = settingsResourceRepository
        )
    }


    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            AccountUiState.Loading,
            viewModel.accountState.value
        )
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

    private val sampleCode = Code(
        myCode = "test_my_code",
        mineCode = "test_mine_code"
    )


}