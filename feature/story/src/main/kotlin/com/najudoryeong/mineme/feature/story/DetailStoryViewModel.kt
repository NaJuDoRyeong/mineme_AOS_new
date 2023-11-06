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
import com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.ui.DetailStoryUiState
import com.najudoryeong.mineme.feature.story.navigation.StoryArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailStoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    userDataRepository: UserDataRepository,
    detailStoryResourceRepository: DetailStoryResourceRepository,
) : ViewModel() {

    private val storyArgs: StoryArgs = StoryArgs(savedStateHandle)

    val detailStoryUiState: StateFlow<DetailStoryUiState> = userDataRepository.userData
        .map { it.jwt }
        .flatMapLatest { jwt ->
            detailStoryResourceRepository.getDetailStory(
                jwt = jwt,
                storyId = storyArgs.storyId.toInt(),
            ).map { DetailStoryUiState.Success(it) }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DetailStoryUiState.Loading,
        )
}
