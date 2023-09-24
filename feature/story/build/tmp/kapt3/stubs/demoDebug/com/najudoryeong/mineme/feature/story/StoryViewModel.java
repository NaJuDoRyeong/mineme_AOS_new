package com.najudoryeong.mineme.feature.story;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/najudoryeong/mineme/feature/story/StoryViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "userDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "storyResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;)V", "allCities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "getAllCities", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "allRegions", "getAllRegions", "calendarState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/najudoryeong/mineme/core/ui/CalendarStoryUiState;", "getCalendarState", "()Lkotlinx/coroutines/flow/StateFlow;", "regionState", "Lcom/najudoryeong/mineme/core/ui/RegionStoryUiState;", "getRegionState", "searchCity", "getSearchCity", "searchRegion", "getSearchRegion", "selectDate", "Ljava/time/LocalDate;", "getSelectDate", "updateCity", "", "newCity", "updateRegion", "newRegion", "updateYearMonth", "year", "", "month", "story_demoDebug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class StoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.data.repository.UserDataRepository userDataRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDate> selectDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchRegion = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchCity = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> allRegions = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> allCities = null;
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
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getSearchRegion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getSearchCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> getAllRegions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> getAllCities() {
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
    
    public final void updateYearMonth(int year, int month) {
    }
    
    public final void updateRegion(@org.jetbrains.annotations.NotNull
    java.lang.String newRegion) {
    }
    
    public final void updateCity(@org.jetbrains.annotations.NotNull
    java.lang.String newCity) {
    }
}