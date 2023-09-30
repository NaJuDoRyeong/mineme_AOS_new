package com.najudoryeong.mineme.core.model.data

data class UserData(
    val darkThemeConfig: DarkThemeConfig,
    val useDynamicColor: Boolean,
    val shouldHideOnboarding: Boolean,
    val jwt : String
)