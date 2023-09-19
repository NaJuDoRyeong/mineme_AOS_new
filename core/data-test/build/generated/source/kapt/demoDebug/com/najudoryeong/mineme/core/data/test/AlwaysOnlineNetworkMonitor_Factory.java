package com.najudoryeong.mineme.core.data.test;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AlwaysOnlineNetworkMonitor_Factory implements Factory<AlwaysOnlineNetworkMonitor> {
  @Override
  public AlwaysOnlineNetworkMonitor get() {
    return newInstance();
  }

  public static AlwaysOnlineNetworkMonitor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AlwaysOnlineNetworkMonitor newInstance() {
    return new AlwaysOnlineNetworkMonitor();
  }

  private static final class InstanceHolder {
    private static final AlwaysOnlineNetworkMonitor_Factory INSTANCE = new AlwaysOnlineNetworkMonitor_Factory();
  }
}
