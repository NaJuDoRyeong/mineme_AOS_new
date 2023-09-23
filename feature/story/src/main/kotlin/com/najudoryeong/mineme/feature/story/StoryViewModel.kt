package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
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

    val regionState: StateFlow<RegionStoryUiState> =
        storyResourceRepository.getRegionStory()
            .map(RegionStoryUiState::Success)
            .stateIn(
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

}