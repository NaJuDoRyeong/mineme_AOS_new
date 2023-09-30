package com.najudoryeong.mineme.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstUserDataRepository;", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "doPreferencesDataSource", "Lcom/najudoryeong/mineme/core/datastore/DoPreferencesDataSource;", "(Lcom/najudoryeong/mineme/core/datastore/DoPreferencesDataSource;)V", "userData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/UserData;", "getUserData", "()Lkotlinx/coroutines/flow/Flow;", "setDarkThemeConfig", "", "darkThemeConfig", "Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;", "(Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDynamicColorPreference", "useDynamicColor", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setJwt", "jwt", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setShouldHideOnboarding", "shouldHideOnboarding", "data_demoDebug"})
public final class OfflineFirstUserDataRepository implements com.najudoryeong.mineme.core.data.repository.UserDataRepository {
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.datastore.DoPreferencesDataSource doPreferencesDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> userData = null;
    
    @javax.inject.Inject
    public OfflineFirstUserDataRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.datastore.DoPreferencesDataSource doPreferencesDataSource) {
        super();
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
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object setJwt(@org.jetbrains.annotations.NotNull
    java.lang.String jwt, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}