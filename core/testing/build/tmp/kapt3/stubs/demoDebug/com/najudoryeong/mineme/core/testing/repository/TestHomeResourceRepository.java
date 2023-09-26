package com.najudoryeong.mineme.core.testing.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/najudoryeong/mineme/core/testing/repository/TestHomeResourceRepository;", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "()V", "homeResourcesFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/najudoryeong/mineme/core/model/data/HomeMainResource;", "getHomeData", "Lkotlinx/coroutines/flow/Flow;", "sendHomeResources", "", "homeMainResources", "testing_demoDebug"})
public final class TestHomeResourceRepository implements com.najudoryeong.mineme.core.data.repository.HomeResourceRepository {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.najudoryeong.mineme.core.model.data.HomeMainResource> homeResourcesFlow = null;
    
    public TestHomeResourceRepository() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.HomeMainResource> getHomeData() {
        return null;
    }
    
    public final void sendHomeResources(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.HomeMainResource homeMainResources) {
    }
}