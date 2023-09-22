package com.najudoryeong.mineme.core.network.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/najudoryeong/mineme/core/network/retrofit/RetrofitDoNetworkApi;", "", "getCalendarStory", "Lcom/najudoryeong/mineme/core/network/retrofit/NetworkResponse;", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryCalendarResource;", "token", "", "year", "month", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeMainResource", "Lcom/najudoryeong/mineme/core/network/model/NetworkHomeMainResource;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegionStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryRegionResource;", "network_demoDebug"})
abstract interface RetrofitDoNetworkApi {
    
    @retrofit2.http.GET(value = "api/test/main/info")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHomeMainResource(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.retrofit.NetworkResponse<com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource>> $completion);
    
    @retrofit2.http.GET(value = "api/v1/stories/location")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRegionStory(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.retrofit.NetworkResponse<com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource>> $completion);
    
    @retrofit2.http.GET(value = "api/v1/stories/calendar")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCalendarStory(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Query(value = "year")
    @org.jetbrains.annotations.NotNull
    java.lang.String year, @retrofit2.http.Query(value = "month")
    @org.jetbrains.annotations.NotNull
    java.lang.String month, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.retrofit.NetworkResponse<com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource>> $completion);
}