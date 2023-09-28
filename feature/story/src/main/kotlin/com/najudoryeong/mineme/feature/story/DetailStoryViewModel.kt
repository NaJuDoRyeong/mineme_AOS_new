package com.najudoryeong.mineme.feature.story

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailStoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    detailStoryResourceRepository: DetailStoryResourceRepository,
) : ViewModel() {



}


sealed interface DetailStoryState {
}
