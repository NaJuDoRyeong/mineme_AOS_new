package com.najudoryeong.mineme.feature.story

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
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
        ).map(DetailStoryUiState::Success).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DetailStoryUiState.Loading,
        )

}


sealed interface DetailStoryUiState {

    data class Success(val detailStoryResource: DetailStoryResource) : DetailStoryUiState

    object Error : DetailStoryUiState

    object Loading : DetailStoryUiState
}
