package com.najudoryeong.mineme.core.network.retrofit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.serialization.json.Json;
import okhttp3.Call;

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
public final class RetrofitDoNetwork_Factory implements Factory<RetrofitDoNetwork> {
  private final Provider<Json> networkJsonProvider;

  private final Provider<Call.Factory> okhttpCallFactoryProvider;

  public RetrofitDoNetwork_Factory(Provider<Json> networkJsonProvider,
      Provider<Call.Factory> okhttpCallFactoryProvider) {
    this.networkJsonProvider = networkJsonProvider;
    this.okhttpCallFactoryProvider = okhttpCallFactoryProvider;
  }

  @Override
  public RetrofitDoNetwork get() {
    return newInstance(networkJsonProvider.get(), okhttpCallFactoryProvider.get());
  }

  public static RetrofitDoNetwork_Factory create(Provider<Json> networkJsonProvider,
      Provider<Call.Factory> okhttpCallFactoryProvider) {
    return new RetrofitDoNetwork_Factory(networkJsonProvider, okhttpCallFactoryProvider);
  }

  public static RetrofitDoNetwork newInstance(Json networkJson, Call.Factory okhttpCallFactory) {
    return new RetrofitDoNetwork(networkJson, okhttpCallFactory);
  }
}
