package com.najudoryeong.mineme.core.analytics;

/**
 * An implementation of AnalyticsHelper just writes the events to logcat. Used in builds where no
 * analytics events should be sent to a backend.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/najudoryeong/mineme/core/analytics/StubAnalyticsHelper;", "Lcom/najudoryeong/mineme/core/analytics/AnalyticsHelper;", "()V", "logEvent", "", "event", "Lcom/najudoryeong/mineme/core/analytics/AnalyticsEvent;", "analytics_demoDebug"})
public final class StubAnalyticsHelper implements com.najudoryeong.mineme.core.analytics.AnalyticsHelper {
    
    @javax.inject.Inject
    public StubAnalyticsHelper() {
        super();
    }
    
    @java.lang.Override
    public void logEvent(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.analytics.AnalyticsEvent event) {
    }
}