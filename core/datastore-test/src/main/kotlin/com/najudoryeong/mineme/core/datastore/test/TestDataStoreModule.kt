package com.najudoryeong.mineme.core.datastore.test

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import com.najudoryeong.mineme.core.datastore.UserPreferences
import com.najudoryeong.mineme.core.datastore.UserPreferencesSerializer
import com.najudoryeong.mineme.core.datastore.di.DataStoreModule
import com.najudoryeong.mineme.core.network.di.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineScope
import org.junit.rules.TemporaryFolder
import javax.inject.Singleton


// 테스트 환경에서 실제 DataStore를 대체하는 모듈을 정의
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataStoreModule::class],
)
object TestDataStoreModule {
    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
        tmpFolder: TemporaryFolder,
    ): DataStore<UserPreferences> =
        tmpFolder.testUserPreferencesDataStore(
            coroutineScope = scope,
            userPreferencesSerializer = userPreferencesSerializer,
        )

    // 임시 폴더에 새 파일을 생성하여 사용하는 테스트용 DataStore를 반환
}


// 임시 폴더에 새 파일을 생성하여 사용하는 테스트용 DataStore를 생성
fun TemporaryFolder.testUserPreferencesDataStore(
    coroutineScope: CoroutineScope,
    userPreferencesSerializer: UserPreferencesSerializer = UserPreferencesSerializer(),
) = DataStoreFactory.create(
    serializer = userPreferencesSerializer,
    scope = coroutineScope,
) {
    newFile("user_preferences_test.pb")
}
