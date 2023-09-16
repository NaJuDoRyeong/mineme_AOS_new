package com.najudoryeong.mineme.core.ui

import com.najudoryeong.mineme.core.model.data.HomeMainResource

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val feed: List<HomeMainResource>,
    ) : HomeUiState
}
