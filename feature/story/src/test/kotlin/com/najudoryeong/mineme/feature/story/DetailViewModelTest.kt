package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.launch
import com.najudoryeong.mineme.core.model.data.Anniversary
import com.najudoryeong.mineme.core.model.data.DetailStory
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.testing.repository.TestDetailStoryResourceRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import kotlinx.coroutines.flow.collect
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
            detailStoryResourceRepository = detailStoryResourceRepository
        )
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            DetailStoryUiState.Loading,
            viewModel.detailStoryUiState.value
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
                author = "홍길동"
            ),
        )
    )

}

