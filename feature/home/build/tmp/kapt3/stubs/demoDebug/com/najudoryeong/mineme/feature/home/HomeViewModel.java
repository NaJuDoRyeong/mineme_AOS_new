package com.najudoryeong.mineme.feature.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/najudoryeong/mineme/feature/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "userDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "homeResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;)V", "homeState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/najudoryeong/mineme/core/ui/HomeUiState;", "getHomeState", "()Lkotlinx/coroutines/flow/StateFlow;", "shouldShowOnboarding", "Lkotlinx/coroutines/flow/Flow;", "", "home_demoDebug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.data.repository.UserDataRepository userDataRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> shouldShowOnboarding = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.HomeUiState> homeState = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.UserDataRepository userDataRepository, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.HomeResourceRepository homeResourceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.najudoryeong.mineme.core.ui.HomeUiState> getHomeState() {
        return null;
    }
}