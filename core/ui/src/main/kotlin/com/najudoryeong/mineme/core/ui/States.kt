package com.najudoryeong.mineme.core.ui

import com.najudoryeong.mineme.core.model.data.Code
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.UserData


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}

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
        val year: String,
        val month: String,
        val storyCalendarResource: StoryCalendarResource
    ) : CalendarStoryUiState
}

sealed interface DetailStoryUiState {
    data class Success(val detailStoryResource: DetailStoryResource) : DetailStoryUiState
    data object Error : DetailStoryUiState
    data object Loading : DetailStoryUiState
}


sealed interface AccountUiState {
    data object Loading : AccountUiState
    data class Success(val code: Code) : AccountUiState
}




