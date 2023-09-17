package com.najudoryeong.mineme.feature.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001\u001a\u001a\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0012\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0012\u0010\r\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007\u001a\"\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\"\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0016"}, d2 = {"CoupleProfile", "", "modifier", "Landroidx/compose/ui/Modifier;", "homeState", "Lcom/najudoryeong/mineme/core/ui/HomeUiState;", "HomeRoute", "viewModel", "Lcom/najudoryeong/mineme/feature/home/HomeViewModel;", "HomeScreen", "HomeScreenLoadingPreview", "homeMainResource", "Lcom/najudoryeong/mineme/core/model/data/HomeMainResource;", "HomeScreenSuccessPreview", "Profile", "profileInfo", "Lcom/najudoryeong/mineme/core/model/data/Person;", "defaultIcon", "", "ProfileImage", "profileImgUrl", "", "home_demoDebug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void HomeRoute(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.feature.home.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.ui.HomeUiState homeState, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CoupleProfile(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.ui.HomeUiState homeState) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void Profile(@org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.Person profileInfo, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, int defaultIcon) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ProfileImage(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String profileImgUrl, int defaultIcon) {
    }
    
    @com.najudoryeong.mineme.core.ui.DevicePreviews
    @androidx.compose.runtime.Composable
    public static final void HomeScreenSuccessPreview(@androidx.compose.ui.tooling.preview.PreviewParameter(provider = com.najudoryeong.mineme.core.ui.HomeMainResourcePreviewParameterProvider.class)
    @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.HomeMainResource homeMainResource) {
    }
    
    @com.najudoryeong.mineme.core.ui.DevicePreviews
    @androidx.compose.runtime.Composable
    public static final void HomeScreenLoadingPreview(@androidx.compose.ui.tooling.preview.PreviewParameter(provider = com.najudoryeong.mineme.core.ui.HomeMainResourcePreviewParameterProvider.class)
    @org.jetbrains.annotations.NotNull
    com.najudoryeong.mineme.core.model.data.HomeMainResource homeMainResource) {
    }
}