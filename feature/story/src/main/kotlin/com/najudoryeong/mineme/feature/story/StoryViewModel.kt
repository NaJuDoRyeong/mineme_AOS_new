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

package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    userDataRepository: UserDataRepository,
    storyResourceRepository: StoryResourceRepository,
) : ViewModel() {

    companion object {
        const val DEFAULT_VALUE = "전체"
    }

    private val _selectDate = MutableStateFlow(LocalDate.now())
    val selectDate: StateFlow<LocalDate> = _selectDate.asStateFlow()

    private val _searchRegion = MutableStateFlow(DEFAULT_VALUE)
    val searchRegion: StateFlow<String> = _searchRegion.asStateFlow()

    private val _searchCity = MutableStateFlow(DEFAULT_VALUE)
    val searchCity: StateFlow<String> = _searchCity.asStateFlow()

    private val _allRegions = MutableStateFlow(listOf(DEFAULT_VALUE))
    val allRegions: StateFlow<List<String>> = _allRegions.asStateFlow()

    private val _allCities = MutableStateFlow(listOf(DEFAULT_VALUE))
    val allCities: StateFlow<List<String>> = _allCities.asStateFlow()


    val regionState: StateFlow<RegionStoryUiState> =
        userDataRepository.userData.map { it.jwt }.flatMapLatest { jwt ->
            combine(
                storyResourceRepository.getRegionStory(jwt),
                _searchRegion,
                _searchCity,
            ) { storyRegionResource, regionQuery, cityQuery ->
                updateRegionsAndCities(storyRegionResource, regionQuery)
                filterStories(storyRegionResource, regionQuery, cityQuery)
            }.map { filteredStories ->
                RegionStoryUiState.Success(StoryRegionResource(filteredStories))
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), RegionStoryUiState.Loading)

    val calendarState: StateFlow<CalendarStoryUiState> =
        userDataRepository.userData.map { it.jwt }.flatMapLatest { jwt ->
            _selectDate.flatMapLatest { date ->
                val year = date.year.toString()
                val month = date.monthValue.toString()
                storyResourceRepository.getCalendarStory(jwt, year, month)
                    .map { storyResource ->
                        CalendarStoryUiState.Success(year, month, storyResource)
                    }
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            CalendarStoryUiState.Loading,
        )

    fun updateYearMonth(year: Int, month: Int) {
        _selectDate.value = LocalDate.of(year, month, 1)
    }

    fun updateRegion(newRegion: String) {
        _searchRegion.value = newRegion
    }

    fun updateCity(newCity: String) {
        _searchCity.value = newCity
    }

    private fun updateRegionsAndCities(
        storyRegionResource: StoryRegionResource,
        regionQuery: String,
    ) {
        if (_allRegions.value.size <= 1) {
            _allRegions.value =
                listOf(DEFAULT_VALUE) + storyRegionResource.stories.map { it.region }.distinct()
        }

        if (regionQuery == DEFAULT_VALUE) {
            _allCities.value = listOf(DEFAULT_VALUE)
            _searchCity.value = DEFAULT_VALUE
        } else if (regionQuery.isNotBlank()) {
            _allCities.value = listOf(DEFAULT_VALUE) + storyRegionResource.stories
                .filter { it.region == regionQuery }
                .map { it.city }
                .distinct()
        }
    }

    private fun filterStories(
        storyRegionResource: StoryRegionResource,
        regionQuery: String,
        cityQuery: String,
    ): List<StoryWithRegion> {
        return storyRegionResource.stories.filter {
            (regionQuery == DEFAULT_VALUE || it.region.contains(regionQuery, ignoreCase = true)) &&
                    (cityQuery == DEFAULT_VALUE || it.city.contains(cityQuery, ignoreCase = true))
        }
    }
}
