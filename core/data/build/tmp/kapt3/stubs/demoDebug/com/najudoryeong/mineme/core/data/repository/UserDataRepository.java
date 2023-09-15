package com.najudoryeong.mineme.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "", "userData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/UserData;", "getUserData", "()Lkotlinx/coroutines/flow/Flow;", "setDarkThemeConfig", "", "darkThemeConfig", "Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;", "(Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDynamicColorPreference", "useDynamicColor", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setShouldHideOnboarding", "shouldHideOnboarding", "data_demoDebug"})
public abstract interface UserDataRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> getUserData();
    
    /**
     * Sets the desired dark theme config.
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setDarkThemeConfig(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.DarkThemeConfig darkThemeConfig, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Sets the preferred dynamic color config.
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setDynamicColorPreference(boolean useDynamicColor, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Sets whether the user has completed the onboarding process.
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setShouldHideOnboarding(boolean shouldHideOnboarding, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}