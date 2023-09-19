// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: com/najudoryeong/mineme/data/user_preferences.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.najudoryeong.mineme.core.datastore;

@kotlin.jvm.JvmName("-initializeuserPreferences")
public inline fun userPreferences(block: com.najudoryeong.mineme.core.datastore.UserPreferencesKt.Dsl.() -> kotlin.Unit): com.najudoryeong.mineme.core.datastore.UserPreferences =
  com.najudoryeong.mineme.core.datastore.UserPreferencesKt.Dsl._create(com.najudoryeong.mineme.core.datastore.UserPreferences.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `UserPreferences`
 */
public object UserPreferencesKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.najudoryeong.mineme.core.datastore.UserPreferences.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.najudoryeong.mineme.core.datastore.UserPreferences.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.najudoryeong.mineme.core.datastore.UserPreferences = _builder.build()

    /**
     * `.DarkThemeConfigProto dark_theme_config = 1;`
     */
    public var darkThemeConfig: com.najudoryeong.mineme.core.datastore.DarkThemeConfigProto
      @JvmName("getDarkThemeConfig")
      get() = _builder.getDarkThemeConfig()
      @JvmName("setDarkThemeConfig")
      set(value) {
        _builder.setDarkThemeConfig(value)
      }
    public var darkThemeConfigValue: kotlin.Int
      @JvmName("getDarkThemeConfigValue")
      get() = _builder.getDarkThemeConfigValue()
      @JvmName("setDarkThemeConfigValue")
      set(value) {
        _builder.setDarkThemeConfigValue(value)
      }
    /**
     * `.DarkThemeConfigProto dark_theme_config = 1;`
     */
    public fun clearDarkThemeConfig() {
      _builder.clearDarkThemeConfig()
    }

    /**
     * <code>bool should_hide_onboarding = 2;</code>
     */
    public var shouldHideOnboarding: kotlin.Boolean
      @JvmName("getShouldHideOnboarding")
      get() = _builder.getShouldHideOnboarding()
      @JvmName("setShouldHideOnboarding")
      set(value) {
        _builder.setShouldHideOnboarding(value)
      }
    /**
     * `bool should_hide_onboarding = 2;`
     */
    public fun clearShouldHideOnboarding() {
      _builder.clearShouldHideOnboarding()
    }

    /**
     * <code>bool use_dynamic_color = 3;</code>
     */
    public var useDynamicColor: kotlin.Boolean
      @JvmName("getUseDynamicColor")
      get() = _builder.getUseDynamicColor()
      @JvmName("setUseDynamicColor")
      set(value) {
        _builder.setUseDynamicColor(value)
      }
    /**
     * `bool use_dynamic_color = 3;`
     */
    public fun clearUseDynamicColor() {
      _builder.clearUseDynamicColor()
    }
  }
}
public inline fun com.najudoryeong.mineme.core.datastore.UserPreferences.copy(block: com.najudoryeong.mineme.core.datastore.UserPreferencesKt.Dsl.() -> kotlin.Unit): com.najudoryeong.mineme.core.datastore.UserPreferences =
  com.najudoryeong.mineme.core.datastore.UserPreferencesKt.Dsl._create(this.toBuilder()).apply { block() }._build()
