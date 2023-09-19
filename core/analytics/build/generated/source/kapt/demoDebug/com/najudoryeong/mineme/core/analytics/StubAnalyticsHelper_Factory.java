package com.najudoryeong.mineme.core.analytics;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class StubAnalyticsHelper_Factory implements Factory<StubAnalyticsHelper> {
  @Override
  public StubAnalyticsHelper get() {
    return newInstance();
  }

  public static StubAnalyticsHelper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StubAnalyticsHelper newInstance() {
    return new StubAnalyticsHelper();
  }

  private static final class InstanceHolder {
    private static final StubAnalyticsHelper_Factory INSTANCE = new StubAnalyticsHelper_Factory();
  }
}
