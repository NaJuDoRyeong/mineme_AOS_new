package com.najudoryeong.mineme.core.network.fake;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/najudoryeong/mineme/core/network/fake/FakeAssetManager;", "", "open", "Ljava/io/InputStream;", "fileName", "", "network_demoDebug"})
public abstract interface FakeAssetManager {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.io.InputStream open(@org.jetbrains.annotations.NotNull
    java.lang.String fileName);
}