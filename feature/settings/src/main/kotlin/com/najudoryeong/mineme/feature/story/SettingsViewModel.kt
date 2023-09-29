package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    settingsResourceRepository: SettingsResourceRepository
) : ViewModel() {


}