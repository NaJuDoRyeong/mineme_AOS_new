package com.najudoryeong.mineme.core.testing.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a[\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0001\u001aA\u0010\u0014\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\u0002\b\u0012\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0015"}, d2 = {"DefaultRoborazziOptions", "Lcom/github/takahirom/roborazzi/RoborazziOptions;", "getDefaultRoborazziOptions", "()Lcom/github/takahirom/roborazzi/RoborazziOptions;", "extractSpecs", "Lcom/najudoryeong/mineme/core/testing/util/TestDeviceSpecs;", "deviceSpec", "", "captureForDevice", "", "A", "Landroidx/activity/ComponentActivity;", "Landroidx/compose/ui/test/junit4/AndroidComposeTestRule;", "Landroidx/test/ext/junit/rules/ActivityScenarioRule;", "deviceName", "screenshotName", "body", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "roborazziOptions", "captureMultiDevice", "testing_demoDebug"})
public final class ScreenshotHelperKt {
    @org.jetbrains.annotations.NotNull
    private static final com.github.takahirom.roborazzi.RoborazziOptions DefaultRoborazziOptions = null;
    
    @org.jetbrains.annotations.NotNull
    public static final com.github.takahirom.roborazzi.RoborazziOptions getDefaultRoborazziOptions() {
        return null;
    }
    
    public static final <A extends androidx.activity.ComponentActivity>void captureMultiDevice(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<A>, A> $this$captureMultiDevice, @org.jetbrains.annotations.NotNull
    java.lang.String screenshotName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> body) {
    }
    
    public static final <A extends androidx.activity.ComponentActivity>void captureForDevice(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<A>, A> $this$captureForDevice, @org.jetbrains.annotations.NotNull
    java.lang.String deviceName, @org.jetbrains.annotations.NotNull
    java.lang.String deviceSpec, @org.jetbrains.annotations.NotNull
    java.lang.String screenshotName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> body, @org.jetbrains.annotations.NotNull
    com.github.takahirom.roborazzi.RoborazziOptions roborazziOptions) {
    }
    
    /**
     * Extracts some properties from the spec string. Note that this function is not exhaustive.
     */
    private static final com.najudoryeong.mineme.core.testing.util.TestDeviceSpecs extractSpecs(java.lang.String deviceSpec) {
        return null;
    }
}