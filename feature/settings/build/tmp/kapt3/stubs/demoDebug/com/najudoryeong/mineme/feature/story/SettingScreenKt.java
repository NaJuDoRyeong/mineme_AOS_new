package com.najudoryeong.mineme.feature.story;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007\u001a4\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007\u001a\b\u0010\u000e\u001a\u00020\u0004H\u0001\u001a\u001a\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"SETTINGS_ACCOUNT_ROUTE", "", "SETTINGS_MAIN_ROUTE", "AccountScreen", "", "onBackClick", "Lkotlin/Function0;", "SettingsItem", "modifier", "Landroidx/compose/ui/Modifier;", "iconRes", "", "descriptionRes", "navigateTo", "SettingsRoute", "SettingsScreen", "navController", "Landroidx/navigation/NavController;", "settings_demoDebug"})
public final class SettingScreenKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_MAIN_ROUTE = "settings_main";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_ACCOUNT_ROUTE = "settings_account";
    
    @androidx.compose.runtime.Composable
    public static final void SettingsRoute() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AccountScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SettingsItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @androidx.annotation.DrawableRes
    int iconRes, @androidx.annotation.StringRes
    int descriptionRes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateTo) {
    }
}