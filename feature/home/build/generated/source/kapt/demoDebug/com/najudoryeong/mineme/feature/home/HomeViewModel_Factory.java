package com.najudoryeong.mineme.feature.home;

import androidx.lifecycle.SavedStateHandle;
import com.najudoryeong.mineme.core.data.repository.UserDataRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UserDataRepository> userDataRepositoryProvider;

  public HomeViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.userDataRepositoryProvider = userDataRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(savedStateHandleProvider.get(), userDataRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider) {
    return new HomeViewModel_Factory(savedStateHandleProvider, userDataRepositoryProvider);
  }

  public static HomeViewModel newInstance(SavedStateHandle savedStateHandle,
      UserDataRepository userDataRepository) {
    return new HomeViewModel(savedStateHandle, userDataRepository);
  }
}
