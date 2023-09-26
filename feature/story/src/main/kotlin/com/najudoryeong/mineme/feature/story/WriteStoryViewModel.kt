package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.LocalDate
import javax.inject.Inject


@HiltViewModel
class WriteStoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val selectedDate : MutableStateFlow<LocalDate> = MutableStateFlow(LocalDate.now())
    val selectedRegion: MutableStateFlow<String> = MutableStateFlow("선택 안함")
    val selectedCity: MutableStateFlow<String> = MutableStateFlow("선택 안함")
}
