/*
 * Copyright 2022 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.najudoryeong.mineme.core.data.repository.fake

import com.najudoryeong.mineme.core.data.repository.UserDataRepository
import com.najudoryeong.mineme.core.datastore.DoPreferencesDataSource
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FakeUserDataRepository @Inject constructor(
    private val doPreferencesDataSource: DoPreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData> =
        doPreferencesDataSource.userData

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
