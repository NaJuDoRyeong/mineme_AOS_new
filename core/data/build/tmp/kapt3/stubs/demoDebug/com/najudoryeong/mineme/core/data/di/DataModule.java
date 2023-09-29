package com.najudoryeong.mineme.core.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0014H\'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\'\u00a8\u0006\u0019"}, d2 = {"Lcom/najudoryeong/mineme/core/data/di/DataModule;", "", "bindsDetailStoryResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/DetailStoryResourceRepository;", "detailStoryResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstDetailStoryResourceRepository;", "bindsHomeResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "homeResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstHomeResourceRepository;", "bindsNetworkMonitor", "Lcom/najudoryeong/mineme/core/data/util/NetworkMonitor;", "networkMonitor", "Lcom/najudoryeong/mineme/core/data/util/ConnectivityManagerNetworkMonitor;", "bindsSettingsResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/SettingsResourceRepository;", "settingsResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstSettingsResourceRepository;", "bindsStoryResourceRepository", "Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstStoryResourceRepository;", "bindsUserDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/UserDataRepository;", "userDataRepository", "Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstUserDataRepository;", "data_demoDebug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface DataModule {
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.UserDataRepository bindsUserDataRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstUserDataRepository userDataRepository);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.util.NetworkMonitor bindsNetworkMonitor(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.util.ConnectivityManagerNetworkMonitor networkMonitor);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.HomeResourceRepository bindsHomeResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstHomeResourceRepository homeResourceRepository);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.StoryResourceRepository bindsStoryResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstStoryResourceRepository homeResourceRepository);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.DetailStoryResourceRepository bindsDetailStoryResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstDetailStoryResourceRepository detailStoryResourceRepository);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.najudoryeong.mineme.core.data.repository.SettingsResourceRepository bindsSettingsResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.repository.OfflineFirstSettingsResourceRepository settingsResourceRepository);
}