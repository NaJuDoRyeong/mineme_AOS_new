package com.najudoryeong.mineme.core.network.di;

import android.content.Context;
import com.najudoryeong.mineme.core.network.fake.FakeAssetManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NetworkModule_ProvidesFakeAssetManagerFactory implements Factory<FakeAssetManager> {
  private final Provider<Context> contextProvider;

  public NetworkModule_ProvidesFakeAssetManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public FakeAssetManager get() {
    return providesFakeAssetManager(contextProvider.get());
  }

  public static NetworkModule_ProvidesFakeAssetManagerFactory create(
      Provider<Context> contextProvider) {
    return new NetworkModule_ProvidesFakeAssetManagerFactory(contextProvider);
  }

  public static FakeAssetManager providesFakeAssetManager(Context context) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providesFakeAssetManager(context));
  }
}
