package com.najudoryeong.mineme.feature.story

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.testing.repository.TestUserDataRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate

class WriteViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


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


    @Test
    fun testUpdateDate() = runTest {
        val year = 2023
        val month = 9
        val day = 28
        viewModel.updateDate(year, month, day)
        assertEquals(LocalDate.of(year, month, day), viewModel.selectedDate.first())
    }

    @Test
    fun testUpdateRegion() = runTest {
        val newRegion = "부산광역시"
        viewModel.updateRegion(newRegion)
        assertEquals(newRegion, viewModel.selectedRegion.first())
    }

    @Test
    fun testUpdateCity() = runTest {
        val newCity = "해운대구"
        viewModel.updateCity(newCity)
        assertEquals(newCity, viewModel.selectedCity.first())
    }

}

