package com.najudoryeong.mineme.core.data.repository.fake;

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
public final class FakeHomeResourceRepository_Factory implements Factory<FakeHomeResourceRepository> {
  @Override
  public FakeHomeResourceRepository get() {
    return newInstance();
  }

  public static FakeHomeResourceRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeHomeResourceRepository newInstance() {
    return new FakeHomeResourceRepository();
  }

  private static final class InstanceHolder {
    private static final FakeHomeResourceRepository_Factory INSTANCE = new FakeHomeResourceRepository_Factory();
  }
}
