package com.najudoryeong.mineme.feature.story

import androidx.lifecycle.SavedStateHandle
import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.testing.repository.TestStoryResourceRepository
import com.najudoryeong.mineme.core.testing.repository.TestUserDataRepository
import com.najudoryeong.mineme.core.testing.util.MainDispatcherRule
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StoryViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val userDataRepository = TestUserDataRepository()
    private val storyResourceRepository = TestStoryResourceRepository()

    private val savedStateHandle = SavedStateHandle()
    private lateinit var viewModel: StoryViewModel


    @Before
    fun setup() {
        viewModel = StoryViewModel(
            savedStateHandle = savedStateHandle,
            userDataRepository = userDataRepository,
            storyResourceRepository = storyResourceRepository
        )
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            RegionStoryUiState.Loading,
            viewModel.regionState.value,
        )

        assertEquals(
            CalendarStoryUiState.Loading,
            viewModel.calendarState.value,
        )
    }


    @Test
    fun regionStateUpdateAfterSelectRegionCity() = runTest {
        val collectJob1 = launch(UnconfinedTestDispatcher()) { viewModel.regionState.collect() }

        storyResourceRepository.sendRegionStoryResource(sampleTopics)

        viewModel.updateRegion("서울")
        viewModel.updateCity("관악구")

        val state = viewModel.regionState.value
        assertTrue(state is RegionStoryUiState.Success)
        val stories = (state).storyRegionResource.stories
        assertTrue(stories.all { it.region == "서울" && it.city == "관악구" })

        collectJob1.cancel()
    }


    private val sampleTopics = StoryRegionResource(
        listOf(
            StoryWithRegion(
                region = "경남",
                city = "창원시",
                posts = listOf(
                    Post(
                        date = "2022-10-01",
                        thumbnail = "https://picsum.photos/200/300",
                        postId = 577
                    ),
                    Post(
                        date = "2022-10-02",
                        thumbnail = "https://picsum.photos/200/300",
                        postId = 578
                    )
                )
            ),
            StoryWithRegion(
                region = "서울",
                city = "관악구",
                posts = listOf(
                    Post(
                        date = "2022-10-03",
                        thumbnail = "https://picsum.photos/200/300",
                        postId = 579
                    ),
                    Post(
                        date = "2022-10-04",
                        thumbnail = "https://picsum.photos/200/300",
                        postId = 580
                    )
                )
            )
        )
    )


}

