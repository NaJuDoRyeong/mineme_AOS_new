/*
 * Copyright 2023 KDW03
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

package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.model.data.Anniversary
import com.najudoryeong.mineme.core.model.data.DetailStory
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.testing.repository.TestDetailStoryResourceRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import com.najudoryeong.mineme.core.ui.DetailStoryUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val savedStateHandle = SavedStateHandle(mapOf("storyId" to "1"))
    private val detailStoryResourceRepository = TestDetailStoryResourceRepository()

    private lateinit var viewModel: DetailStoryViewModel

    @Before
    fun setup() {
        viewModel = DetailStoryViewModel(
            savedStateHandle = savedStateHandle,
            detailStoryResourceRepository = detailStoryResourceRepository,
        )
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            DetailStoryUiState.Loading,
            viewModel.detailStoryUiState.value,
        )
    }

    @Test
    fun testDetailStorySuccessState() = runTest {
        val collectJob1 = launch(UnconfinedTestDispatcher()) { viewModel.detailStoryUiState.collect() }

        detailStoryResourceRepository.sendDetailStoryResource(sampleDetailStoryResource)

        val state = viewModel.detailStoryUiState.value
        assertTrue(state is DetailStoryUiState.Success)
        assertEquals(sampleDetailStoryResource, state.detailStoryResource)

        collectJob1.cancel()
    }

    private val sampleDetailStoryResource = DetailStoryResource(
        stories = listOf(
            DetailStory(
                region = "서울",
                city = "강남구",
                isAnniversary = "y",
                anniversary = Anniversary(type = "type1", day = 100),
                date = "2022-10-01",
                images = listOf("https://sample.com/image1.jpg"),
                postId = 1,
                content = "샘플 내용입니다.",
                author = "홍길동",
            ),
        ),
    )
}
