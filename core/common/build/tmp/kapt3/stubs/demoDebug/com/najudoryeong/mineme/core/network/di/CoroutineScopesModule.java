package com.najudoryeong.mineme.core.network.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/najudoryeong/mineme/core/network/di/CoroutineScopesModule;", "", "()V", "providesCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "common_demoDebug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class CoroutineScopesModule {
    @org.jetbrains.annotations.NotNull
    public static final com.najudoryeong.mineme.core.network.di.CoroutineScopesModule INSTANCE = null;
    
    private CoroutineScopesModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @ApplicationScope
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineScope providesCoroutineScope(@com.najudoryeong.mineme.core.network.Dispatcher(doDispatcher = com.najudoryeong.mineme.core.network.DoDispatchers.Default)
    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
}