package com.najudoryeong.mineme.core.data.test;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/najudoryeong/mineme/core/data/test/TestDataModule;", "", "bindsHomeResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "homeResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstHomeResourceRepository;", "bindsNetworkMonitor", "Lcom/najudoryeong/mineme/core/data/util/NetworkMonitor;", "networkMonitor", "Lcom/najudoryeong/mineme/core/data/test/AlwaysOnlineNetworkMonitor;", "bindsUserDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "userDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/fake/FakeUserDataRepository;", "data-test_demoDebug"})
@dagger.hilt.testing.TestInstallIn(components = {dagger.hilt.components.SingletonComponent.class}, replaces = {com.najudoryeong.mineme.core.data.di.DataModule.class})
public abstract interface TestDataModule {
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.UserDataRepository bindsUserDataRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.fake.FakeUserDataRepository userDataRepository);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.util.NetworkMonitor bindsNetworkMonitor(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.test.AlwaysOnlineNetworkMonitor networkMonitor);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.HomeResourceRepository bindsHomeResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstHomeResourceRepository homeResourceRepository);
}