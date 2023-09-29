package com.najudoryeong.mineme.core.network.fake;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/najudoryeong/mineme/core/network/fake/FakeDoNetworkDataSource;", "Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "networkJson", "Lkotlinx/serialization/json/Json;", "assets", "Lcom/najudoryeong/mineme/core/network/fake/FakeAssetManager;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/serialization/json/Json;Lcom/najudoryeong/mineme/core/network/fake/FakeAssetManager;)V", "getCalendarStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryCalendarResource;", "year", "", "month", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCode", "Lcom/najudoryeong/mineme/core/network/model/NetworkCode;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkDetailStoryResource;", "storyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeData", "Lcom/najudoryeong/mineme/core/network/model/NetworkHomeMainResource;", "getRegionStory", "Lcom/najudoryeong/mineme/core/network/model/NetworkStoryRegionResource;", "Companion", "network_demoDebug"})
@kotlin.OptIn(markerClass = {kotlinx.serialization.ExperimentalSerializationApi.class})
public final class FakeDoNetworkDataSource implements com.najudoryeong.mineme.core.network.DoNetworkDataSource {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json networkJson = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.network.fake.FakeAssetManager assets = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String HOME_ASSET = "home.json";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String StoryRegion_ASSET = "story_region.json";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String StoryCalendar_ASSET = "story_calendar.json";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DetailStory_ASSET = "detail_story.json";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CODE_ASSET = "code.json";
    @org.jetbrains.annotations.NotNull
    public static final com.najudoryeong.mineme.core.network.fake.FakeDoNetworkDataSource.Companion Companion = null;
    
    @javax.inject.Inject
    public FakeDoNetworkDataSource(@com.najudoryeong.mineme.core.network.Dispatcher(doDispatcher = com.najudoryeong.mineme.core.network.DoDispatchers.IO)
    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.json.Json networkJson, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.network.fake.FakeAssetManager assets) {
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
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getDetailStory(int storyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCode(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkCode> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/najudoryeong/mineme/core/network/fake/FakeDoNetworkDataSource$Companion;", "", "()V", "CODE_ASSET", "", "DetailStory_ASSET", "HOME_ASSET", "StoryCalendar_ASSET", "StoryRegion_ASSET", "network_demoDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}