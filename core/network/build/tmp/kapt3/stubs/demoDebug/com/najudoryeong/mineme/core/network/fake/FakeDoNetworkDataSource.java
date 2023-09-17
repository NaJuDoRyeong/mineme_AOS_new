package com.najudoryeong.mineme.core.network.fake;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/najudoryeong/mineme/core/network/fake/FakeDoNetworkDataSource;", "Lcom/najudoryeong/mineme/core/network/DoNetworkDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "networkJson", "Lkotlinx/serialization/json/Json;", "assets", "Lcom/najudoryeong/mineme/core/network/fake/FakeAssetManager;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/serialization/json/Json;Lcom/najudoryeong/mineme/core/network/fake/FakeAssetManager;)V", "getHomeData", "Lcom/najudoryeong/mineme/core/network/model/NetworkHomeMainResource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "network_demoDebug"})
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
    @kotlin.OptIn(markerClass = {kotlinx.serialization.ExperimentalSerializationApi.class})
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getHomeData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/najudoryeong/mineme/core/network/fake/FakeDoNetworkDataSource$Companion;", "", "()V", "HOME_ASSET", "", "network_demoDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}