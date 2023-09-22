package com.najudoryeong.mineme.feature.story;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/najudoryeong/mineme/feature/story/StoryViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "userDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "storyResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;)V", "calendarState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/najudoryeong/mineme/core/ui/CalendarStoryUiState;", "getCalendarState", "()Lkotlinx/coroutines/flow/StateFlow;", "regionState", "Lcom/najudoryeong/mineme/core/ui/RegionStoryUiState;", "getRegionState", "selectDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/time/LocalDate;", "getSelectDate", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "shouldShowCalendar", "", "getShouldShowCalendar", "story_demoDebug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class StoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.data.repository.UserDataRepository userDataRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDate> selectDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> shouldShowCalendar = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.RegionStoryUiState> regionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.CalendarStoryUiState> calendarState = null;
    
    @javax.inject.Inject
    public StoryViewModel(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.UserDataRepository userDataRepository, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.StoryResourceRepository storyResourceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDate> getSelectDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getShouldShowCalendar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.RegionStoryUiState> getRegionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.CalendarStoryUiState> getCalendarState() {
        return null;
    }
}