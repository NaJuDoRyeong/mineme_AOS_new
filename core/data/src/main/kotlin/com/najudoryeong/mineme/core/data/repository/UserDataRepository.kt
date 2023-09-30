package com.najudoryeong.mineme.core.data.repository

import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.model.data.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>


    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)


    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)


    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)

    suspend fun setJwt(jwt: String)

}