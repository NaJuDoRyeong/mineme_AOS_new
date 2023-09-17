package com.najudoryeong.mineme.core.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u00c6\u0001\u0010\b\u001a\u00020\t*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00042(\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f2\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\f0\u000f\u00a2\u0006\u0002\b\u00132(\u0010\u0014\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f2(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"suspendRunCatching", "Lkotlin/Result;", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeListSync", "", "Lcom/najudoryeong/mineme/core/data/Synchronizer;", "versionReader", "Lcom/najudoryeong/mineme/core/datastore/ChangeListVersions;", "", "changeListFetcher", "Lkotlin/Function2;", "", "Lcom/najudoryeong/mineme/core/network/model/NetworkChangeList;", "versionUpdater", "Lkotlin/ExtensionFunctionType;", "modelDeleter", "", "", "modelUpdater", "(Lcom/najudoryeong/mineme/core/data/Synchronizer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_demoDebug"})
public final class SyncUtilitiesKt {
    
    /**
     * Attempts [block], returning a successful [Result] if it succeeds, otherwise a [Result.Failure]
     * taking care not to break structured concurrency
     */
    private static final <T extends java.lang.Object>java.lang.Object suspendRunCatching(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> block, kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>> $completion) {
        return null;
    }
    
    /**
     * Utility function for syncing a repository with the network.
     * [versionReader] Reads the current version of the model that needs to be synced
     * [changeListFetcher] Fetches the change list for the model
     * [versionUpdater] Updates the [ChangeListVersions] after a successful sync
     * [modelDeleter] Deletes models by consuming the ids of the models that have been deleted.
     * [modelUpdater] Updates models by consuming the ids of the models that have changed.
     *
     * Note that the blocks defined above are never run concurrently, and the [Synchronizer]
     * implementation must guarantee this.
     */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object changeListSync(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.data.Synchronizer $this$changeListSync, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.najudoryeong.mineme.core.datastore.ChangeListVersions, java.lang.Integer> versionReader, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super java.util.List<com.najudoryeong.mineme.core.network.model.NetworkChangeList>>, ? extends java.lang.Object> changeListFetcher, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.najudoryeong.mineme.core.datastore.ChangeListVersions, ? super java.lang.Integer, com.najudoryeong.mineme.core.datastore.ChangeListVersions> versionUpdater, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.util.List<java.lang.String>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> modelDeleter, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.util.List<java.lang.String>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> modelUpdater, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}