package com.najudoryeong.mineme.core.datastore;

import androidx.datastore.core.DataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DoPreferencesDataSource_Factory implements Factory<DoPreferencesDataSource> {
  private final Provider<DataStore<UserPreferences>> userPreferencesProvider;

  public DoPreferencesDataSource_Factory(
      Provider<DataStore<UserPreferences>> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  @Override
  public DoPreferencesDataSource get() {
    return newInstance(userPreferencesProvider.get());
  }

  public static DoPreferencesDataSource_Factory create(
      Provider<DataStore<UserPreferences>> userPreferencesProvider) {
    return new DoPreferencesDataSource_Factory(userPreferencesProvider);
  }

  public static DoPreferencesDataSource newInstance(DataStore<UserPreferences> userPreferences) {
    return new DoPreferencesDataSource(userPreferences);
  }
}
