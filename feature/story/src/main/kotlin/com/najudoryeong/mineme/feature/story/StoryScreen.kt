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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.designsystem.component.DoTextButton
import com.najudoryeong.mineme.core.designsystem.component.DynamicAsyncImage
import com.najudoryeong.mineme.core.designsystem.component.LocationDropdownMenu
import com.najudoryeong.mineme.core.designsystem.component.Picker
import com.najudoryeong.mineme.core.designsystem.component.rememberPickerState
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.DevicePreviews
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

@Composable
internal fun StoryRoute(
    modifier: Modifier = Modifier,
    viewModel: StoryViewModel = hiltViewModel(),
    onStoryClick: (Int) -> Unit,
    showCalendar: MutableStateFlow<Boolean>,
) {
    val shouldShowCalendar by showCalendar.collectAsStateWithLifecycle()
    val regionState by viewModel.regionState.collectAsStateWithLifecycle()
    val calendarState by viewModel.calendarState.collectAsStateWithLifecycle()
    val allRegions by viewModel.allRegions.collectAsStateWithLifecycle()
    val allCities by viewModel.allCities.collectAsStateWithLifecycle()

    StoryScreen(
        modifier = modifier,
        shouldShowCalendar = shouldShowCalendar,
        regionState = regionState,
        calendarState = calendarState,
        onStoryClick = onStoryClick,
        onUpdateDate = viewModel::updateYearMonth,
        updateRegion = viewModel::updateRegion,
        updateCity = viewModel::updateCity,
        allRegions = allRegions,
        allCities = allCities,
    )
}

@Composable
internal fun StoryScreen(
    modifier: Modifier = Modifier,
    shouldShowCalendar: Boolean,
    regionState: RegionStoryUiState,
    calendarState: CalendarStoryUiState,
    onStoryClick: (Int) -> Unit = {},
    onUpdateDate: (Int, Int) -> Unit = { _, _ -> },
    updateRegion: (String) -> Unit = {},
    updateCity: (String) -> Unit = {},
    allRegions: List<String> = emptyList(),
    allCities: List<String> = emptyList(),
) {
    val isRegionLoading = regionState is RegionStoryUiState.Loading
    val isCalendarLoading = calendarState is CalendarStoryUiState.Loading

    Box(modifier.fillMaxSize()) {
        if (shouldShowCalendar) {
            CalendarView(
                calendarState = calendarState,
                onStoryClick = onStoryClick,
                onUpdateDate = onUpdateDate,
            )
        } else {
            RegionView(
                regionState = regionState,
                onStoryClick = onStoryClick,
                updateRegion = updateRegion,
                updateCity = updateCity,
                allRegions = allRegions,
                allCities = allCities,
            )
        }

        AnimatedVisibility(
            visible = (shouldShowCalendar && isCalendarLoading) || (!shouldShowCalendar && isRegionLoading),
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight },
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
            ) + fadeOut(),
        ) {
            val loadingContentDescription =
                if (shouldShowCalendar) {
                    stringResource(id = R.string.calendar_loading)
                } else {
                    stringResource(id = R.string.region_loading)
                }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
            ) {
                DoOverlayLoadingWheel(
                    modifier = Modifier.align(Alignment.Center),
                    contentDesc = loadingContentDescription,
                )
            }
        }
    }
}

@Composable
fun CalendarView(
    modifier: Modifier = Modifier,
    calendarState: CalendarStoryUiState,
    onStoryClick: (Int) -> Unit,
    onUpdateDate: (Int, Int) -> Unit,
) {
    when (calendarState) {
        CalendarStoryUiState.Loading -> Unit
        is CalendarStoryUiState.Success -> {
            MonthlyCalendar(
                year = calendarState.year.toInt(),
                month = calendarState.month.toInt(),
                stories = calendarState.storyCalendarResource.stories.first().posts,
                onStoryClicked = onStoryClick,
                onUpdateDate = onUpdateDate,
                modifier = modifier.testTag("Story:CalendarView"),
            )
        }
    }
}

@Composable
fun RegionView(
    modifier: Modifier = Modifier,
    regionState: RegionStoryUiState,
    allRegions: List<String>,
    allCities: List<String>,
    updateRegion: (String) -> Unit,
    updateCity: (String) -> Unit,
    onStoryClick: (Int) -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    when (regionState) {
        RegionStoryUiState.Loading -> Unit
        is RegionStoryUiState.Success -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    LocationDropdownMenu(
                        modifier = Modifier
                            .width(screenWidth / 2 - 24.dp)
                            .weight(1f)
                            .padding(4.dp)
                            .testTag("RegionDropDown"),
                        menuList = allRegions,
                        onItemSelected = updateRegion,
                    )
                    LocationDropdownMenu(
                        modifier = Modifier
                            .width(screenWidth / 2 - 24.dp)
                            .weight(1f)
                            .padding(4.dp),
                        menuList = allCities,
                        onItemSelected = updateCity,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                RegionStoriesGrid(
                    stories = regionState.storyRegionResource.stories,
                    onStoryClick = onStoryClick,
                )
            }
        }
    }
}

@Composable
fun RegionStoriesGrid(
    modifier: Modifier = Modifier,
    stories: List<StoryWithRegion>,
    onStoryClick: (Int) -> Unit,
) {
    val allPosts = remember { mutableStateOf(emptyList<Pair<Post, StoryWithRegion>>()) }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageSize = (screenWidth - 48.dp) / 2

    LaunchedEffect(stories) {
        withContext(Dispatchers.Default) {
            stories.flatMap { story ->
                story.posts.map { post -> Pair(post, story) }
            }
        }.also {
            allPosts.value = it
        }
    }

    if (allPosts.value.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = DoIcons.no_story_inStory.resourceId),
                contentDescription = null,
            )
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.testTag("story:posts"),
        ) {
            items(allPosts.value.size) { index ->
                val (post, storyWithPost) = allPosts.value[index]
                PostItem(
                    imgModifier = Modifier.size(imageSize),
                    post = post,
                    region = storyWithPost.region,
                    city = storyWithPost.city,
                    onStoryClick = onStoryClick,
                )
            }
        }
    }
}

@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    imgModifier: Modifier = Modifier,
    post: Post,
    region: String,
    city: String,
    onStoryClick: (Int) -> Unit,
) {
    val regionCityStr = "$region $city"

    Column(
        modifier = modifier
            .padding(4.dp)
            .clickable {
                onStoryClick(post.postId)
            },
        horizontalAlignment = Alignment.Start,
    ) {
        DynamicAsyncImage(
            modifier = imgModifier
                .clip(RoundedCornerShape(8.dp)),
            imageUrl = post.thumbnail,
            contentDescription = null,
        )

        Text(
            text = regionCityStr,
            style = MaterialTheme.typography.labelLarge,
        )

        Text(
            text = post.date,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Composable
fun MonthlyCalendar(
    stories: List<Post>,
    onStoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    year: Int,
    month: Int,
    onUpdateDate: (Int, Int) -> Unit,
) {
    val storiesMap = remember { mutableStateOf(mapOf<LocalDate, Post>()) }

    LaunchedEffect(stories) {
        withContext(Dispatchers.Default) {
            stories.associateBy { LocalDate.parse(it.date) }
        }.also {
            storiesMap.value = it
        }
    }

    val daysInMonth = YearMonth.of(year, month).lengthOfMonth()
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val daysBefore = firstDayOfMonth.dayOfWeek.value % DAYS_IN_WEEK

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        YearMonthPicker(
            selectedYear = year,
            selectedMonth = month,
            onYearMonthChanged = onUpdateDate,
        )
        WeekdaysRow()
        CalendarRows(storiesMap.value, daysBefore, daysInMonth, year, month, onStoryClicked)
    }
}

@Composable
fun YearMonthPicker(
    selectedYear: Int,
    selectedMonth: Int,
    onYearMonthChanged: (Int, Int) -> Unit,
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { showDialog = true }
            .padding(top = 16.dp)
            .testTag("Story:DatePicker"),

        ) {
        Text(
            text = "${selectedYear}년 / ${selectedMonth}월",
            style = MaterialTheme.typography.titleLarge,
        )
        Icon(
            imageVector = DoIcons.ArrowDown,
            contentDescription = "Dropdown Arrow",
            modifier = Modifier.padding(start = 8.dp),
        )
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Column(
                Modifier.fillMaxWidth().height(300.dp).padding(16.dp).background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                val yearPickerState = rememberPickerState()
                val startIndexYear = yearList.indexOf(
                    selectedYear.toString(),
                )
                val monthPickerState = rememberPickerState()
                val startIndexMonth = monthList.indexOf(String.format("%02d", selectedMonth))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Picker(
                        modifier = Modifier.weight(1f),
                        items = yearList,
                        state = yearPickerState,
                        startIndex = startIndexYear,
                        visibleItemsCount = 3,
                        textModifier = Modifier.padding(8.dp),
                    )
                    Picker(
                        state = monthPickerState,
                        items = monthList,
                        visibleItemsCount = 3,
                        modifier = Modifier.weight(1f),
                        textModifier = Modifier.padding(8.dp),
                        startIndex = startIndexMonth,
                        pickerTag = "MonthPicker",
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DoTextButton(
                        onClick = { showDialog = false },
                        modifier = Modifier.weight(1f),
                    ) {
                        Text("취소")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    DoTextButton(
                        onClick = {
                            onYearMonthChanged(
                                yearPickerState.selectedItem.toInt(),
                                monthPickerState.selectedItem.toInt(),
                            )
                            showDialog = false
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Text("확인")
                    }
                }
            }
        }
    }
}

@Composable
fun WeekdaysRow(modifier: Modifier = Modifier) {
    val daysInKorean = listOf("월", "화", "수", "목", "금", "토", "일")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp),
    ) {
        DayOfWeek.values().forEach { dayOfWeek ->
            Text(
                modifier = Modifier.weight(1f),
                text = daysInKorean[dayOfWeek.ordinal],
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Composable
fun CalendarRows(
    storiesMap: Map<LocalDate, Post>,
    daysBefore: Int,
    daysInMonth: Int,
    year: Int,
    month: Int,
    onStoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val totalDays = daysBefore + daysInMonth
    for (i in 0 until totalDays step DAYS_IN_WEEK) {
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            for (j in i until i + 7) {
                val day = j - daysBefore + 1
                if (j in daysBefore until daysBefore + daysInMonth) {
                    CalendarItem(
                        day = day,
                        post = storiesMap[LocalDate.of(year, month, day)],
                        onStoryClick = onStoryClicked,
                        modifier = modifier
                            .weight(1f)
                            .size(60.dp)
                            .padding(2.dp),
                    )
                } else {
                    Box(
                        modifier = modifier
                            .weight(1f)
                            .size(45.dp)
                            .padding(2.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun CalendarItem(
    day: Int,
    post: Post?,
    onStoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val radiusPx = with(density) { 45.dp.toPx() } / 2

    Box(
        modifier = modifier.background(
            brush = Brush.radialGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.tertiaryContainer,
                    MaterialTheme.colorScheme.tertiaryContainer,
                ),
                radius = radiusPx,
            ),
            shape = roundedIrregularShape(),
        ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "$day", style = MaterialTheme.typography.bodyMedium)
        post?.let {
            DynamicAsyncImage(
                it.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .clip(roundedIrregularShape())
                    .clickable {
                        onStoryClick(post.postId)
                    },
            )
        }
    }
}

@Composable
fun roundedIrregularShape(): Shape {
    return object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density,
        ): Outline {
            return Outline.Generic(
                Path().apply {
                    val scaleX = size.width / 46f
                    val scaleY = size.height / 48f

                    moveTo(36.403f * scaleX, 42.868f * scaleY)
                    cubicTo(
                        26.23f * scaleX,
                        47.249f * scaleY,
                        4.996f * scaleX,
                        47.898f * scaleY,
                        0.996f * scaleX,
                        25.536f * scaleY,
                    )
                    cubicTo(
                        -0.004f * scaleX,
                        12.361f * scaleY,
                        8.033f * scaleX,
                        -3.979f * scaleY,
                        32.447f * scaleX,
                        2.368f * scaleY,
                    )
                    cubicTo(
                        51.245f * scaleX,
                        7.255f * scaleY,
                        51.118f * scaleX,
                        36.531f * scaleY,
                        36.403f * scaleX,
                        42.868f * scaleY,
                    )
                    close()
                },
            )
        }
    }
}

@DevicePreviews
@Composable
fun RegionViewPreview() {
    val samplePosts = listOf(
        Post("2022-10-01", "https://picsum.photos/1000/1000", 577),
        Post("2022-10-02", "https://picsum.photos/1000/1000", 578),
    )
    val sampleStoryWithRegion = StoryWithRegion("서울", "강남구", samplePosts)
    val sampleRegionState =
        RegionStoryUiState.Success(StoryRegionResource(listOf(sampleStoryWithRegion)))

    RegionView(
        regionState = sampleRegionState,
        allRegions = listOf("서울", "부산"),
        allCities = listOf("강남구", "해운대구"),
        updateRegion = {},
        updateCity = {},
        onStoryClick = {},
    )
}

const val DAYS_IN_WEEK = 7
const val START_YEAR = 2018
const val END_YEAR = 2050
const val TOTAL_MONTHS = 12

val yearList = (START_YEAR..END_YEAR).map { it.toString() }
val monthList = (1..TOTAL_MONTHS).map { String.format("%02d", it) }
