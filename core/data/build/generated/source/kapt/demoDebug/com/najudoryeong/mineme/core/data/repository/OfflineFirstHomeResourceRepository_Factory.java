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
public final class OfflineFirstHomeResourceRepository_Factory implements Factory<OfflineFirstHomeResourceRepository> {
  private final Provider<DoNetworkDataSource> networkProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public OfflineFirstHomeResourceRepository_Factory(Provider<DoNetworkDataSource> networkProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.networkProvider = networkProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public OfflineFirstHomeResourceRepository get() {
    return newInstance(networkProvider.get(), ioDispatcherProvider.get());
  }

  public static OfflineFirstHomeResourceRepository_Factory create(
      Provider<DoNetworkDataSource> networkProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new OfflineFirstHomeResourceRepository_Factory(networkProvider, ioDispatcherProvider);
  }

  public static OfflineFirstHomeResourceRepository newInstance(DoNetworkDataSource network,
      CoroutineDispatcher ioDispatcher) {
    return new OfflineFirstHomeResourceRepository(network, ioDispatcher);
  }
}
