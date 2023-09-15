package com.najudoryeong.mineme.core.datastore;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/najudoryeong/mineme/core/datastore/DoPreferencesDataSource;", "", "userPreferences", "Landroidx/datastore/core/DataStore;", "Lcom/najudoryeong/mineme/core/datastore/UserPreferences;", "(Landroidx/datastore/core/DataStore;)V", "userData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/UserData;", "getUserData", "()Lkotlinx/coroutines/flow/Flow;", "setDarkThemeConfig", "", "darkThemeConfig", "Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;", "(Lcom/najudoryeong/mineme/core/model/data/DarkThemeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDynamicColorPreference", "useDynamicColor", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setShouldHideOnboarding", "shouldHideOnboarding", "datastore_demoDebug"})
public final class DoPreferencesDataSource {
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.core.DataStore<com.najudoryeong.mineme.core.datastore.UserPreferences> userPreferences = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> userData = null;
    
    @javax.inject.Inject
    public DoPreferencesDataSource(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<com.najudoryeong.mineme.core.datastore.UserPreferences> userPreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.UserData> getUserData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDarkThemeConfig(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.DarkThemeConfig darkThemeConfig, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDynamicColorPreference(boolean useDynamicColor, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setShouldHideOnboarding(boolean shouldHideOnboarding, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}