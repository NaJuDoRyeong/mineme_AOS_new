package com.najudoryeong.mineme.core.testing.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/najudoryeong/mineme/core/testing/repository/TestUserDataRepository;", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "()V", "_userData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/najudoryeong/mineme/core/model/data/UserData;", "currentUserData", "getCurrentUserData", "()Lcom/najudoryeong/mineme/core/model/data/UserData;", "userData", "Lkotlinx/coroutines/flow/Flow;", "getUserData", "()Lkotlinx/coroutines/flow/Flow;", "setDarkThemeConfig", "", "darkThemeConfig", "Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;", "(Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDynamicColorPreference", "useDynamicColor", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setShouldHideOnboarding", "shouldHideOnboarding", "setUserData", "testing_demoDebug"})
public final class TestUserDataRepository implements com.najudoryeong.mineme.core.data.repository.UserDataRepository {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.najudoryeong.mineme.core.model.data.UserData> _userData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> userData = null;
    
    public TestUserDataRepository() {
        super();
    }
    
    private final com.najudoryeong.mineme.core.model.data.UserData getCurrentUserData() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> getUserData() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object setDarkThemeConfig(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.DarkThemeConfig darkThemeConfig, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object setDynamicColorPreference(boolean useDynamicColor, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object setShouldHideOnboarding(boolean shouldHideOnboarding, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * A test-only API to allow setting of user data directly.
     */
    public final void setUserData(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.UserData userData) {
    }
}