package com.najudoryeong.mineme.core.network.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.serialization.json.Json;

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
public final class FakeDoNetworkDataSource_Factory implements Factory<FakeDoNetworkDataSource> {
  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Json> networkJsonProvider;

  private final Provider<FakeAssetManager> assetsProvider;

  public FakeDoNetworkDataSource_Factory(Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<Json> networkJsonProvider, Provider<FakeAssetManager> assetsProvider) {
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.networkJsonProvider = networkJsonProvider;
    this.assetsProvider = assetsProvider;
  }

  @Override
  public FakeDoNetworkDataSource get() {
    return newInstance(ioDispatcherProvider.get(), networkJsonProvider.get(), assetsProvider.get());
  }

  public static FakeDoNetworkDataSource_Factory create(
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Json> networkJsonProvider,
      Provider<FakeAssetManager> assetsProvider) {
    return new FakeDoNetworkDataSource_Factory(ioDispatcherProvider, networkJsonProvider, assetsProvider);
  }

  public static FakeDoNetworkDataSource newInstance(CoroutineDispatcher ioDispatcher,
      Json networkJson, FakeAssetManager assets) {
    return new FakeDoNetworkDataSource(ioDispatcher, networkJson, assets);
  }
}
