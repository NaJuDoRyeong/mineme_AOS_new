package com.najudoryeong.mineme.core.testing.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/najudoryeong/mineme/core/testing/repository/TestStoryResourceRepository;", "Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;", "()V", "storyCalendarResourceFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/najudoryeong/mineme/core/model/data/StoryCalendarResource;", "storyRegionResourceFlow", "Lcom/najudoryeong/mineme/core/model/data/StoryRegionResource;", "getCalendarStory", "Lkotlinx/coroutines/flow/Flow;", "year", "", "month", "getRegionStory", "sendCalendarStoryResource", "", "storyCalendarResource", "sendRegionStoryResource", "storyRegionResource", "testing_demoDebug"})
public final class TestStoryResourceRepository implements com.najudoryeong.mineme.core.data.repository.StoryResourceRepository {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.najudoryeong.mineme.core.model.data.StoryRegionResource> storyRegionResourceFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.najudoryeong.mineme.core.model.data.StoryCalendarResource> storyCalendarResourceFlow = null;
    
    public TestStoryResourceRepository() {
        super();
    }
    
    public final boolean sendRegionStoryResource(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.StoryRegionResource storyRegionResource) {
        return false;
    }
    
    public final boolean sendCalendarStoryResource(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.StoryCalendarResource storyCalendarResource) {
        return false;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.StoryRegionResource> getRegionStory() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.StoryCalendarResource> getCalendarStory(@org.jetbrains.annotations.NotNull
    java.lang.String year, @org.jetbrains.annotations.NotNull
    java.lang.String month) {
        return null;
    }
}