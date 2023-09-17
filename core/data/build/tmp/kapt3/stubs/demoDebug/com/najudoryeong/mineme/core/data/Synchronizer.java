package com.najudoryeong.mineme.core.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\b\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f*\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/najudoryeong/mineme/core/data/Synchronizer;", "", "getChangeListVersions", "Lcom/najudoryeong/mineme/core/datastore/ChangeListVersions;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChangeListVersions", "", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sync", "", "Lcom/najudoryeong/mineme/core/data/Syncable;", "(Lcom/najudoryeong/mineme/core/data/Syncable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_demoDebug"})
public abstract interface Synchronizer {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getChangeListVersions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.najudoryeong.mineme.core.datastore.ChangeListVersions> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateChangeListVersions(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.najudoryeong.mineme.core.datastore.ChangeListVersions, com.najudoryeong.mineme.core.datastore.ChangeListVersions> update, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Syntactic sugar to call [Syncable.syncWith] while omitting the synchronizer argument
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object sync(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.Syncable $completion, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        /**
         * Syntactic sugar to call [Syncable.syncWith] while omitting the synchronizer argument
         */
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object sync(@org.jetbrains.annotations.NotNull
        com.najudoryeong.mineme.core.data.Synchronizer $this, @org.jetbrains.annotations.NotNull
        com.najudoryeong.mineme.core.data.Syncable $receiver, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
            return null;
        }
    }
}