package com.najudoryeong.mineme.core.network.di;

import android.content.Context;
import coil.ImageLoader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Call;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NetworkModule_ImageLoaderFactory implements Factory<ImageLoader> {
  private final Provider<Call.Factory> okHttpCallFactoryProvider;

  private final Provider<Context> applicationProvider;

  public NetworkModule_ImageLoaderFactory(Provider<Call.Factory> okHttpCallFactoryProvider,
      Provider<Context> applicationProvider) {
    this.okHttpCallFactoryProvider = okHttpCallFactoryProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public ImageLoader get() {
    return imageLoader(okHttpCallFactoryProvider.get(), applicationProvider.get());
  }

  public static NetworkModule_ImageLoaderFactory create(
      Provider<Call.Factory> okHttpCallFactoryProvider, Provider<Context> applicationProvider) {
    return new NetworkModule_ImageLoaderFactory(okHttpCallFactoryProvider, applicationProvider);
  }

  public static ImageLoader imageLoader(Call.Factory okHttpCallFactory, Context application) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.imageLoader(okHttpCallFactory, application));
  }
}
