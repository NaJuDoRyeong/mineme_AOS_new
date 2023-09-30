package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.datastore.DoPreferencesDataSource
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstUserDataRepository @Inject constructor(
    private val doPreferencesDataSource: DoPreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData>
        = doPreferencesDataSource.userData

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        doPreferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }
    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        doPreferencesDataSource.setDynamicColorPreference(useDynamicColor)
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        doPreferencesDataSource.setShouldHideOnboarding(shouldHideOnboarding)
    }

    override suspend fun setJwt(jwt: String) {
        doPreferencesDataSource.setJwt(jwt)
    }

}