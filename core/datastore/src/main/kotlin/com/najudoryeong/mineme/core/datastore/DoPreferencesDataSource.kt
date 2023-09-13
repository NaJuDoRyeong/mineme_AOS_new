package com.najudoryeong.mineme.core.datastore

import androidx.datastore.core.DataStore
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.model.data.UserData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DoPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {

    val userData = flow<UserData> {
        userPreferences.data
        UserData(
            DarkThemeConfig.DARK, false, false
        )
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {

    }

    suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {

    }

    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {

    }

}