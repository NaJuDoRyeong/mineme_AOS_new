package com.najudoryeong.mineme.core.ui

import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val homeMainResource: HomeMainResource,
    ) : HomeUiState
}


sealed interface RegionStoryUiState {

    data object Loading : RegionStoryUiState

    data class Success(
        val storyRegionResource: StoryRegionResource
    ) : RegionStoryUiState
}


sealed interface CalendarStoryUiState {
    data object Loading : CalendarStoryUiState

    data class Success(
        val year : String,
        val month : String,
        val storyCalendarResource: StoryCalendarResource
    ) : CalendarStoryUiState
}