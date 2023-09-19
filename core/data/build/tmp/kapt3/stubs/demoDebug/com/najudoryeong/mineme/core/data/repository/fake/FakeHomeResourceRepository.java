package com.najudoryeong.mineme.core.data.repository.fake;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/najudoryeong/mineme/core/data/repository/fake/FakeHomeResourceRepository;", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "()V", "getHomeData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/HomeMainResource;", "data_demoDebug"})
public final class FakeHomeResourceRepository implements com.najudoryeong.mineme.core.data.repository.HomeResourceRepository {
    
    @javax.inject.Inject
    public FakeHomeResourceRepository() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.HomeMainResource> getHomeData() {
        return null;
    }
}