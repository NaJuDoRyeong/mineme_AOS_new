package com.najudoryeong.mineme.feature.story;

import androidx.lifecycle.SavedStateHandle;
import com.najudoryeong.mineme.core.data.repository.StoryResourceRepository;
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
public final class StoryViewModel_Factory implements Factory<StoryViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UserDataRepository> userDataRepositoryProvider;

  private final Provider<StoryResourceRepository> storyResourceRepositoryProvider;

  public StoryViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider,
      Provider<StoryResourceRepository> storyResourceRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.userDataRepositoryProvider = userDataRepositoryProvider;
    this.storyResourceRepositoryProvider = storyResourceRepositoryProvider;
  }

  @Override
  public StoryViewModel get() {
    return newInstance(savedStateHandleProvider.get(), userDataRepositoryProvider.get(), storyResourceRepositoryProvider.get());
  }

  public static StoryViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserDataRepository> userDataRepositoryProvider,
      Provider<StoryResourceRepository> storyResourceRepositoryProvider) {
    return new StoryViewModel_Factory(savedStateHandleProvider, userDataRepositoryProvider, storyResourceRepositoryProvider);
  }

  public static StoryViewModel newInstance(SavedStateHandle savedStateHandle,
      UserDataRepository userDataRepository, StoryResourceRepository storyResourceRepository) {
    return new StoryViewModel(savedStateHandle, userDataRepository, storyResourceRepository);
  }
}
