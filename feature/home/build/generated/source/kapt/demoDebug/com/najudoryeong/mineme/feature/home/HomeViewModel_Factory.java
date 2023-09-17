package com.najudoryeong.mineme.feature.home;

import androidx.lifecycle.SavedStateHandle;
import com.najudoryeong.mineme.core.data.repository.HomeResourceRepository;
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

  private final Provider<HomeResourceRepository> homeResourceRepositoryProvider;

  public HomeViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider,
      Provider<HomeResourceRepository> homeResourceRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.userDataRepositoryProvider = userDataRepositoryProvider;
    this.homeResourceRepositoryProvider = homeResourceRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(savedStateHandleProvider.get(), userDataRepositoryProvider.get(), homeResourceRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider,
      Provider<HomeResourceRepository> homeResourceRepositoryProvider) {
    return new HomeViewModel_Factory(savedStateHandleProvider, userDataRepositoryProvider, homeResourceRepositoryProvider);
  }

  public static HomeViewModel newInstance(SavedStateHandle savedStateHandle,
      UserDataRepository userDataRepository, HomeResourceRepository homeResourceRepository) {
    return new HomeViewModel(savedStateHandle, userDataRepository, homeResourceRepository);
  }
}
