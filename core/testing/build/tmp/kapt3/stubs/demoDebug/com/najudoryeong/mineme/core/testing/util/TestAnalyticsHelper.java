package com.najudoryeong.mineme.core.testing.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/najudoryeong/mineme/core/testing/util/TestAnalyticsHelper;", "Lcom/najudoryeong/mineme/core/analytics/AnalyticsHelper;", "()V", "events", "", "Lcom/najudoryeong/mineme/core/analytics/AnalyticsEvent;", "hasLogged", "", "event", "logEvent", "", "testing_demoDebug"})
public final class TestAnalyticsHelper implements com.najudoryeong.mineme.core.analytics.AnalyticsHelper {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.najudoryeong.mineme.core.analytics.AnalyticsEvent> events = null;
    
    public TestAnalyticsHelper() {
        super();
    }
    
    @java.lang.Override
    public void logEvent(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.analytics.AnalyticsEvent event) {
    }
    
    public final boolean hasLogged(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.analytics.AnalyticsEvent event) {
        return false;
    }
}