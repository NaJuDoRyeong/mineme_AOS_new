package com.najudoryeong.mineme.feature.story

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.feature.story.navigation.StoryArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class DetailStoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    detailStoryResourceRepository: DetailStoryResourceRepository,
) : ViewModel() {

    private val storyArgs: StoryArgs = StoryArgs(savedStateHandle)
    val storyId = storyArgs.storyId

    val detailStoryUiState: StateFlow<DetailStoryUiState> =
        detailStoryResourceRepository.getDetailStory(
            storyArgs.storyId.toInt()
        ).map { detailStoryResource ->
            DetailStoryUiState.Success(
                detailStoryResource
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DetailStoryUiState.Loading,
        )

}


sealed interface DetailStoryUiState {

    data class Success(val news: DetailStoryResource) : DetailStoryUiState

    object Error : DetailStoryUiState

    object Loading : DetailStoryUiState
}
