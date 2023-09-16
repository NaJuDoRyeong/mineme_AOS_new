package com.najudoryeong.mineme.core.network.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
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
public final class NetworkModule_OkHttpCallFactoryFactory implements Factory<Call.Factory> {
  @Override
  public Call.Factory get() {
    return okHttpCallFactory();
  }

  public static NetworkModule_OkHttpCallFactoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Call.Factory okHttpCallFactory() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.okHttpCallFactory());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_OkHttpCallFactoryFactory INSTANCE = new NetworkModule_OkHttpCallFactoryFactory();
  }
}
