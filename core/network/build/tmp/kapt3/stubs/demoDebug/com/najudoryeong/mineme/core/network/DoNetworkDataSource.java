package com.najudoryeong.mineme.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2 = {"Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;", "", "getHomeData", "", "Lcom/najudoryeong/mineme/core/network/model/NetworkHomeMainResource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_demoDebug"})
public abstract interface DoNetworkDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHomeData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource>> $completion);
}