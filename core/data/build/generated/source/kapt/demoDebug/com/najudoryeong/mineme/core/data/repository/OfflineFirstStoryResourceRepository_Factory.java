package com.najudoryeong.mineme.core.data.repository;

import com.najudoryeong.mineme.core.network.DoNetworkDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class OfflineFirstStoryResourceRepository_Factory implements Factory<OfflineFirstStoryResourceRepository> {
  private final Provider<DoNetworkDataSource> networkProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public OfflineFirstStoryResourceRepository_Factory(Provider<DoNetworkDataSource> networkProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.networkProvider = networkProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public OfflineFirstStoryResourceRepository get() {
    return newInstance(networkProvider.get(), ioDispatcherProvider.get());
  }

  public static OfflineFirstStoryResourceRepository_Factory create(
      Provider<DoNetworkDataSource> networkProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new OfflineFirstStoryResourceRepository_Factory(networkProvider, ioDispatcherProvider);
  }

  public static OfflineFirstStoryResourceRepository newInstance(DoNetworkDataSource network,
      CoroutineDispatcher ioDispatcher) {
    return new OfflineFirstStoryResourceRepository(network, ioDispatcher);
  }
}
