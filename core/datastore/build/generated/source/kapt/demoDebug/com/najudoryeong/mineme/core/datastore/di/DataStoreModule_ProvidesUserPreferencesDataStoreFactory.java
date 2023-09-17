package com.najudoryeong.mineme.core.datastore.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.najudoryeong.mineme.core.datastore.UserPreferences;
import com.najudoryeong.mineme.core.datastore.UserPreferencesSerializer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "dagger.hilt.android.qualifiers.ApplicationContext",
    "com.najudoryeong.mineme.core.network.Dispatcher",
    "com.najudoryeong.mineme.core.network.di.ApplicationScope"
})
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
public final class DataStoreModule_ProvidesUserPreferencesDataStoreFactory implements Factory<DataStore<UserPreferences>> {
  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<CoroutineScope> scopeProvider;

  private final Provider<UserPreferencesSerializer> userPreferencesSerializerProvider;

  public DataStoreModule_ProvidesUserPreferencesDataStoreFactory(Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<CoroutineScope> scopeProvider,
      Provider<UserPreferencesSerializer> userPreferencesSerializerProvider) {
    this.contextProvider = contextProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.scopeProvider = scopeProvider;
    this.userPreferencesSerializerProvider = userPreferencesSerializerProvider;
  }

  @Override
  public DataStore<UserPreferences> get() {
    return providesUserPreferencesDataStore(contextProvider.get(), ioDispatcherProvider.get(), scopeProvider.get(), userPreferencesSerializerProvider.get());
  }

  public static DataStoreModule_ProvidesUserPreferencesDataStoreFactory create(
      Provider<Context> contextProvider, Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<CoroutineScope> scopeProvider,
      Provider<UserPreferencesSerializer> userPreferencesSerializerProvider) {
    return new DataStoreModule_ProvidesUserPreferencesDataStoreFactory(contextProvider, ioDispatcherProvider, scopeProvider, userPreferencesSerializerProvider);
  }

  public static DataStore<UserPreferences> providesUserPreferencesDataStore(Context context,
      CoroutineDispatcher ioDispatcher, CoroutineScope scope,
      UserPreferencesSerializer userPreferencesSerializer) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.providesUserPreferencesDataStore(context, ioDispatcher, scope, userPreferencesSerializer));
  }
}
