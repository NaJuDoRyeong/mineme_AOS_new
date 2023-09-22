package com.najudoryeong.mineme.core.network.retrofit;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/najudoryeong/mineme/core/network/retrofit/RetrofitDoNetwork;", "Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;", "networkJson", "Lkotlinx/serialization/json/Json;", "okhttpCallFactory", "Lokhttp3/Call$Factory;", "(Lkotlinx/serialization/json/Json;Lokhttp3/Call$Factory;)V", "networkApi", "Lcom/najudoryeong/mineme/core/network/retrofit/RetrofitDoNetworkApi;", "kotlin.jvm.PlatformType", "getCalendarStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryCalendarResource;", "year", "", "month", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeData", "Lcom/najudoryeong/mineme/core/network/model/NetworkHomeMainResource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegionStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryRegionResource;", "network_demoDebug"})
public final class RetrofitDoNetwork implements com.najudoryeong.mineme.core.network.DoNetworkDataSource {
    private final com.najudoryeong.mineme.core.network.retrofit.RetrofitDoNetworkApi networkApi = null;
    
    @javax.inject.Inject
    public RetrofitDoNetwork(@org.jetbrains.annotations.NotNull
    kotlinx.serialization.json.Json networkJson, @org.jetbrains.annotations.NotNull
    okhttp3.Call.Factory okhttpCallFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getHomeData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getRegionStory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCalendarStory(@org.jetbrains.annotations.NotNull
    java.lang.String year, @org.jetbrains.annotations.NotNull
    java.lang.String month, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource> $completion) {
        return null;
    }
}