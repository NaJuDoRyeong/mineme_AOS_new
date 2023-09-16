package com.najudoryeong.mineme.core.network.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ/\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/najudoryeong/mineme/core/network/retrofit/RetrofitNiaNetworkApi;", "", "getNewsResources", "Lcom/najudoryeong/mineme/core/network/retrofit/NetworkResponse;", "", "error/NonExistentClass", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewsResourcesChangeList", "after", "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopicChangeList", "getTopics", "network_demoDebug"})
abstract interface RetrofitNiaNetworkApi {
    
    @retrofit2.http.GET(value = "topics")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopics(@retrofit2.http.Query(value = "id")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> ids, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.retrofit.NetworkResponse<java.util.List<error.NonExistentClass>>> $completion);
    
    @retrofit2.http.GET(value = "newsresources")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNewsResources(@retrofit2.http.Query(value = "id")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> ids, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.retrofit.NetworkResponse<java.util.List<error.NonExistentClass>>> $completion);
    
    @retrofit2.http.GET(value = "changelists/topics")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopicChangeList(@retrofit2.http.Query(value = "after")
    @org.jetbrains.annotations.Nullable
    java.lang.Integer after, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "changelists/newsresources")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNewsResourcesChangeList(@retrofit2.http.Query(value = "after")
    @org.jetbrains.annotations.Nullable
    java.lang.Integer after, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<error.NonExistentClass>> $completion);
}