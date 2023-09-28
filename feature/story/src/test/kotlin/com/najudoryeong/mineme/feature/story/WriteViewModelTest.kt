package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.testing.repository.TestUserDataRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WriteViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val userDataRepository = TestUserDataRepository()

    private val savedStateHandle = SavedStateHandle()
    private lateinit var viewModel: WriteStoryViewModel

    @Before
    fun setup() {
        viewModel = WriteStoryViewModel(
            savedStateHandle = savedStateHandle
        )
    }


    @Test
    fun testInitValue() = runTest {
        assertEquals(koreanProvinces, viewModel.allRegions.first())
        assertEquals(koreanCities[koreanProvinces.first()] ?: emptyList<String>(), viewModel.allCities.first())
        assertEquals(koreanProvinces.first(), viewModel.selectedRegion.first())
        // 첫번째 region에 해당하는 첫 번째 도시가 selectedCity 초기값과 일치하는지
        assertEquals(koreanCities[koreanProvinces.first()]?.first() ?: "", viewModel.selectedCity.first())
    }



}