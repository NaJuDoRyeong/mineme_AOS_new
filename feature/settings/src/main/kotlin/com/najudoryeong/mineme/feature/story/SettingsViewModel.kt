package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository
import com.najudoryeong.mineme.core.ui.AccountUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    settingsResourceRepository: SettingsResourceRepository
) : ViewModel() {

    val accountState: StateFlow<AccountUiState> =
        settingsResourceRepository.getCode().map(AccountUiState::Success).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AccountUiState.Loading,
        )

}