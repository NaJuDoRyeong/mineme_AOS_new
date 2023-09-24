package com.najudoryeong.mineme.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/najudoryeong/mineme/core/data/repository/StoryResourceRepository;", "", "getCalendarStory", "Lkotlinx/coroutines/flow/Flow;", "Lcom/najudoryeong/mineme/core/model/data/StoryCalendarResource;", "year", "", "month", "getRegionStory", "Lcom/najudoryeong/mineme/core/model/data/StoryRegionResource;", "data_demoDebug"})
public abstract interface StoryResourceRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.StoryRegionResource> getRegionStory();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.najudoryeong.mineme.core.model.data.StoryCalendarResource> getCalendarStory(@org.jetbrains.annotations.NotNull
    java.lang.String year, @org.jetbrains.annotations.NotNull
    java.lang.String month);
}