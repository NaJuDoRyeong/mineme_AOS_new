package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository
import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userDataRepository: UserDataRepository,
    storyResourceRepository: StoryResourceRepository
) {

}