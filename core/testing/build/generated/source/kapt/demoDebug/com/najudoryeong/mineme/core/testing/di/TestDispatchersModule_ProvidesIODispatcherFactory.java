package com.najudoryeong.mineme.core.testing.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.test.TestDispatcher;

@ScopeMetadata
@QualifierMetadata("com.najudoryeong.mineme.core.network.Dispatcher")
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
public final class TestDispatchersModule_ProvidesIODispatcherFactory implements Factory<CoroutineDispatcher> {
  private final Provider<TestDispatcher> testDispatcherProvider;

  public TestDispatchersModule_ProvidesIODispatcherFactory(
      Provider<TestDispatcher> testDispatcherProvider) {
    this.testDispatcherProvider = testDispatcherProvider;
  }

  @Override
  public CoroutineDispatcher get() {
    return providesIODispatcher(testDispatcherProvider.get());
  }

  public static TestDispatchersModule_ProvidesIODispatcherFactory create(
      Provider<TestDispatcher> testDispatcherProvider) {
    return new TestDispatchersModule_ProvidesIODispatcherFactory(testDispatcherProvider);
  }

  public static CoroutineDispatcher providesIODispatcher(TestDispatcher testDispatcher) {
    return Preconditions.checkNotNullFromProvides(TestDispatchersModule.INSTANCE.providesIODispatcher(testDispatcher));
  }
}
