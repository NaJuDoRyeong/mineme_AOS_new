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
            homeResourceRepository = homeResourceRepository
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