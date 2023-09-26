package com.najudoryeong.mineme.feature.story;

@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@org.robolectric.annotation.GraphicsMode(value = org.robolectric.annotation.GraphicsMode.Mode.NATIVE)
@org.robolectric.annotation.Config(application = dagger.hilt.android.testing.HiltTestApplication.class, sdk = {33})
@org.robolectric.annotation.LooperMode(value = org.robolectric.annotation.LooperMode.Mode.PAUSED)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0007R%\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00048G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/najudoryeong/mineme/feature/story/StoryScreenShotTests;", "", "()V", "composeTestRule", "Landroidx/compose/ui/test/junit4/AndroidComposeTestRule;", "Landroidx/test/ext/junit/rules/ActivityScenarioRule;", "Landroidx/activity/ComponentActivity;", "getComposeTestRule", "()Landroidx/compose/ui/test/junit4/AndroidComposeTestRule;", "storyCalendarResource", "Lcom/najudoryeong/mineme/core/model/data/StoryCalendarResource;", "storyRegionResource", "Lcom/najudoryeong/mineme/core/model/data/StoryRegionResource;", "storyRegionResourceEmpty", "setTimeZone", "", "storyCalendarScreen", "storyRegionEmptyScreen", "storyRegionScreen", "story_demoDebugUnitTest"})
public final class StoryScreenShotTests {
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<androidx.activity.ComponentActivity>, androidx.activity.ComponentActivity> composeTestRule = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.model.data.StoryCalendarResource storyCalendarResource = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.model.data.StoryRegionResource storyRegionResource = null;
    @org.jetbrains.annotations.NotNull
    private final com.najudoryeong.mineme.core.model.data.StoryRegionResource storyRegionResourceEmpty = null;
    
    public StoryScreenShotTests() {
        super();
    }
    
    @org.junit.Rule
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<androidx.activity.ComponentActivity>, androidx.activity.ComponentActivity> getComposeTestRule() {
        return null;
    }
    
    @org.junit.Before
    public final void setTimeZone() {
    }
    
    @org.junit.Test
    public final void storyRegionScreen() {
    }
    
    @org.junit.Test
    public final void storyRegionEmptyScreen() {
    }
    
    @org.junit.Test
    public final void storyCalendarScreen() {
    }
}