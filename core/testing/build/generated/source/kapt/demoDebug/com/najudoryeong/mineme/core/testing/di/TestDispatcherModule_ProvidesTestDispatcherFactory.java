package com.najudoryeong.mineme.core.testing.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.test.TestDispatcher;

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
public final class TestDispatcherModule_ProvidesTestDispatcherFactory implements Factory<TestDispatcher> {
  @Override
  public TestDispatcher get() {
    return providesTestDispatcher();
  }

  public static TestDispatcherModule_ProvidesTestDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TestDispatcher providesTestDispatcher() {
    return Preconditions.checkNotNullFromProvides(TestDispatcherModule.INSTANCE.providesTestDispatcher());
  }

  private static final class InstanceHolder {
    private static final TestDispatcherModule_ProvidesTestDispatcherFactory INSTANCE = new TestDispatcherModule_ProvidesTestDispatcherFactory();
  }
}
