package com.najudoryeong.mineme.feature.story.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\b\u001a\u00020\u0004*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a:\u0010\t\u001a\u00020\u0004*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"storyNavigationRoute", "", "storyWriteRoute", "navigateToStory", "", "Landroidx/navigation/NavController;", "navOptions", "Landroidx/navigation/NavOptions;", "navigateToWriteStory", "storyScreen", "Landroidx/navigation/NavGraphBuilder;", "onStoryClick", "Lkotlin/Function1;", "", "showCalendar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "nestedGraphs", "Lkotlin/Function0;", "writeStoryScreen", "onBackClick", "story_demoDebug"})
public final class StoryNavigationKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String storyNavigationRoute = "story_route";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String storyWriteRoute = "story_write_route";
    
    public static final void navigateToStory(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController $this$navigateToStory, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavOptions navOptions) {
    }
    
    public static final void storyScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavGraphBuilder $this$storyScreen, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onStoryClick, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> showCalendar, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> nestedGraphs) {
    }
    
    public static final void navigateToWriteStory(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController $this$navigateToWriteStory, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavOptions navOptions) {
    }
    
    public static final void writeStoryScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavGraphBuilder $this$writeStoryScreen, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
}