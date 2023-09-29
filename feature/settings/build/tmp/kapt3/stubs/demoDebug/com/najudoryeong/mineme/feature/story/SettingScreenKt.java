package com.najudoryeong.mineme.feature.story;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007\u001a4\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0007\u001a\b\u0010\u0013\u001a\u00020\bH\u0001\u001a$\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0001\u001a,\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"SETTINGS_ACCOUNT_ROUTE", "", "SETTINGS_ANNOUNCEMENT_ROUTE", "SETTINGS_CONTACT_ROUTE", "SETTINGS_MAIN_ROUTE", "SETTINGS_NOTIFICATION_ROUTE", "SETTINGS_SECURITY_ROUTE", "AccountScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "onBackClick", "Lkotlin/Function0;", "titleRes", "", "SettingsItem", "iconRes", "descriptionRes", "navigateTo", "SettingsRoute", "SettingsScreen", "navController", "Landroidx/navigation/NavController;", "SettingsToolBar", "settings_demoDebug"})
public final class SettingScreenKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_MAIN_ROUTE = "settings_main";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_ACCOUNT_ROUTE = "settings_account";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_NOTIFICATION_ROUTE = "settings_notification";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_SECURITY_ROUTE = "settings_security";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_ANNOUNCEMENT_ROUTE = "settings_announcement";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SETTINGS_CONTACT_ROUTE = "settings_contact";
    
    @androidx.compose.runtime.Composable
    public static final void SettingsRoute() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AccountScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @androidx.annotation.StringRes
    int titleRes) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @androidx.annotation.StringRes
    int titleRes) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SettingsItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @androidx.annotation.DrawableRes
    int iconRes, @androidx.annotation.StringRes
    int descriptionRes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateTo) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SettingsToolBar(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @androidx.annotation.StringRes
    int titleRes) {
    }
}