package com.najudoryeong.mineme.core.data.repository;

import com.najudoryeong.mineme.core.datastore.DoPreferencesDataSource;
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
public final class OfflineFirstUserDataRepository_Factory implements Factory<OfflineFirstUserDataRepository> {
  private final Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider;

  public OfflineFirstUserDataRepository_Factory(
      Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider) {
    this.doPreferencesDataSourceProvider = doPreferencesDataSourceProvider;
  }

  @Override
  public OfflineFirstUserDataRepository get() {
    return newInstance(doPreferencesDataSourceProvider.get());
  }

  public static OfflineFirstUserDataRepository_Factory create(
      Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider) {
    return new OfflineFirstUserDataRepository_Factory(doPreferencesDataSourceProvider);
  }

  public static OfflineFirstUserDataRepository newInstance(
      DoPreferencesDataSource doPreferencesDataSource) {
    return new OfflineFirstUserDataRepository(doPreferencesDataSource);
  }
}
