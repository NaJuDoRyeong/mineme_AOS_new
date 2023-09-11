package com.najudoryeong.mineme.core.data.repository

import android.service.autofill.UserData
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstUserDataRepository @Inject constructor(
    private val niaPreferencesDataSource: DoPreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData>
        get() = TODO("Not yet implemented")

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        TODO("Not yet implemented")
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        TODO("Not yet implemented")
    }

}