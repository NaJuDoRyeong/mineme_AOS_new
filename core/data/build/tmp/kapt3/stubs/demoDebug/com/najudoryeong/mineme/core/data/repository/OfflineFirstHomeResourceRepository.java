package com.najudoryeong.mineme.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/najudoryeong/mineme/core/data/repository/OfflineFirstHomeResourceRepository;", "Lcom/najudoryeong/mineme/core/data/repository/HomeResourceRepository;", "network", "Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getHomeData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/HomeMainResource;", "data_demoDebug"})
public final class OfflineFirstHomeResourceRepository implements com.najudoryeong.mineme.core.data.repository.HomeResourceRepository {
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.network.DoNetworkDataSource network = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject
    public OfflineFirstHomeResourceRepository(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.network.DoNetworkDataSource network, @com.najudoryeong.mineme.core.network.Dispatcher(doDispatcher = com.najudoryeong.mineme.core.network.DoDispatchers.IO)
    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.HomeMainResource> getHomeData() {
        return null;
    }
}