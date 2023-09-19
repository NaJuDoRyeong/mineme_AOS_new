package com.najudoryeong.mineme.uitesthiltmanifest;

/**
 * A [ComponentActivity] annotated with [AndroidEntryPoint] for use in tests, as a workaround
 * for https://github.com/google/dagger/issues/3394
 */
@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/najudoryeong/mineme/uitesthiltmanifest/HiltComponentActivity;", "Landroidx/activity/ComponentActivity;", "()V", "ui-test-hilt-manifest_demoDebug"})
public final class HiltComponentActivity extends androidx.activity.ComponentActivity {
    
    public HiltComponentActivity() {
        super();
    }
}