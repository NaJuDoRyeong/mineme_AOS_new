package com.najudoryeong.mineme.core.datastore;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
  @Override
  public DoPreferencesDataSource get() {
    return newInstance();
  }

  public static DoPreferencesDataSource_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DoPreferencesDataSource newInstance() {
    return new DoPreferencesDataSource();
  }

  private static final class InstanceHolder {
    private static final DoPreferencesDataSource_Factory INSTANCE = new DoPreferencesDataSource_Factory();
  }
}
