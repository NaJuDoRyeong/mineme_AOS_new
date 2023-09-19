package com.najudoryeong.mineme.core.data.repository.fake;

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
public final class FakeUserDataRepository_Factory implements Factory<FakeUserDataRepository> {
  private final Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider;

  public FakeUserDataRepository_Factory(
      Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider) {
    this.doPreferencesDataSourceProvider = doPreferencesDataSourceProvider;
  }

  @Override
  public FakeUserDataRepository get() {
    return newInstance(doPreferencesDataSourceProvider.get());
  }

  public static FakeUserDataRepository_Factory create(
      Provider<DoPreferencesDataSource> doPreferencesDataSourceProvider) {
    return new FakeUserDataRepository_Factory(doPreferencesDataSourceProvider);
  }

  public static FakeUserDataRepository newInstance(
      DoPreferencesDataSource DoPreferencesDataSource) {
    return new FakeUserDataRepository(DoPreferencesDataSource);
  }
}
