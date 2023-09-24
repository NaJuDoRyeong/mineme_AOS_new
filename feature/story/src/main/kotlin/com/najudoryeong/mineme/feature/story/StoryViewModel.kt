package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userDataRepository: UserDataRepository,
    storyResourceRepository: StoryResourceRepository,
) : ViewModel() {

    val selectDate: MutableStateFlow<LocalDate> = MutableStateFlow(LocalDate.now())

    val searchRegion: MutableStateFlow<String> = MutableStateFlow("")
    val searchCity: MutableStateFlow<String> = MutableStateFlow("")

    val allRegions: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val allCities: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    val regionState: StateFlow<RegionStoryUiState> =
        combine(
            storyResourceRepository.getRegionStory(),
            searchRegion,
            searchCity
        ) { storyRegionResource, regionQuery, cityQuery ->

            // 초기에만 filter
            if (allRegions.value.isEmpty()) {
                allRegions.value = storyRegionResource.stories.map { it.region }.distinct()
            }

            // 선택된 지역에 따라 해당하는 도시만 allCities에 업데이트
            if (regionQuery.isNotBlank()) {
                allCities.value = storyRegionResource.stories
                    .filter { it.region == regionQuery }
                    .map { it.city }
                    .distinct()
            } else if (allCities.value.isEmpty()) {
                allCities.value = storyRegionResource.stories.map { it.city }.distinct()
            }

            // Filter stories based on region and city
            storyRegionResource.stories.filter {
                (regionQuery.isBlank() || it.region.contains(regionQuery, ignoreCase = true)) &&
                        (cityQuery.isBlank() || it.city.contains(cityQuery, ignoreCase = true))
            }
        }.map { filteredStories ->
            RegionStoryUiState.Success(
                StoryRegionResource(filteredStories)
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = RegionStoryUiState.Loading,
        )


    val calendarState: StateFlow<CalendarStoryUiState> =
        selectDate.flatMapLatest { date ->
            val year = date.year.toString()
            val month = date.monthValue.toString()
            storyResourceRepository.getCalendarStory(
                year, month
            ).map { storyResource ->
                CalendarStoryUiState.Success(
                    year = year,
                    month = month,
                    storyCalendarResource = storyResource
                )
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CalendarStoryUiState.Loading,
        )

    fun updateYearMonth(year: Int, month: Int) {
        selectDate.value = LocalDate.of(year, month, 1)
    }

    fun updateRegion(newRegion: String) {
        searchRegion.value = newRegion
    }

    fun updateCity(newCity: String) {
        searchCity.value = newCity
    }


}