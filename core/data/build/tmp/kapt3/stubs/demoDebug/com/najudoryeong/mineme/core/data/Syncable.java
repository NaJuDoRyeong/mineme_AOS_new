package com.najudoryeong.mineme.core.data;

/**
 * Interface marker for a class that is synchronized with a remote source. Syncing must not be
 * performed concurrently and it is the [Synchronizer]'s responsibility to ensure this.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/najudoryeong/mineme/core/data/Syncable;", "", "syncWith", "", "synchronizer", "Lcom/najudoryeong/mineme/core/data/Synchronizer;", "(Lcom/najudoryeong/mineme/core/data/Synchronizer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_demoDebug"})
public abstract interface Syncable {
    
    /**
     * Synchronizes the local database backing the repository with the network.
     * Returns if the sync was successful or not.
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object syncWith(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.Synchronizer synchronizer, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}