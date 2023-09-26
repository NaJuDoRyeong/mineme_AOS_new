package com.najudoryeong.mineme.core.testing.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/najudoryeong/mineme/core/testing/di/TestDispatchersModule;", "", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "testDispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "providesIODispatcher", "testing_demoDebug"})
@dagger.hilt.testing.TestInstallIn(components = {dagger.hilt.components.SingletonComponent.class}, replaces = {com.najudoryeong.mineme.core.network.di.DispatchersModule.class})
public final class TestDispatchersModule {
    @org.jetbrains.annotations.NotNull
    public static final com.najudoryeong.mineme.core.testing.di.TestDispatchersModule INSTANCE = null;
    
    private TestDispatchersModule() {
        super();
    }
    
    @dagger.Provides
    @com.najudoryeong.mineme.core.network.Dispatcher(doDispatcher = com.najudoryeong.mineme.core.network.DoDispatchers.IO)
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher providesIODispatcher(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.test.TestDispatcher testDispatcher) {
        return null;
    }
    
    @dagger.Provides
    @com.najudoryeong.mineme.core.network.Dispatcher(doDispatcher = com.najudoryeong.mineme.core.network.DoDispatchers.Default)
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher providesDefaultDispatcher(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.test.TestDispatcher testDispatcher) {
        return null;
    }
}