package com.najudoryeong.mineme.feature.story

import android.util.Log
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
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.designsystem.component.DynamicAsyncImage
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth


@Composable
internal fun StoryRoute(
    modifier: Modifier = Modifier,
    viewModel: StoryViewModel = hiltViewModel(),
    onStoryClick: (Int) -> Unit
) {

    val shouldShowCalendar by viewModel.shouldShowCalendar.collectAsStateWithLifecycle()
    val regionState by viewModel.regionState.collectAsStateWithLifecycle()
    val calendarState by viewModel.calendarState.collectAsStateWithLifecycle()

    StoryScreen(
        modifier = modifier,
        shouldShowCalendar = shouldShowCalendar,
        regionState = regionState,
        calendarState = calendarState,
        onStoryClick = onStoryClick
    )
}

@Composable
internal fun StoryScreen(
    modifier: Modifier = Modifier,
    shouldShowCalendar: Boolean,
    regionState: RegionStoryUiState,
    calendarState: CalendarStoryUiState,
    onStoryClick: (Int) -> Unit
) {

    val isRegionLoading = regionState is RegionStoryUiState.Loading
    val isCalendarLoading = calendarState is CalendarStoryUiState.Loading

    Box(modifier.fillMaxSize()) {

        if (shouldShowCalendar) {
            CalendarView(
                calendarState = calendarState,
                onStoryClick = onStoryClick
            )
        } else {
            RegionView(
                regionState = regionState,
                onStoryClick = onStoryClick
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
                if (shouldShowCalendar) stringResource(id = R.string.calendar_loading)
                else stringResource(id = R.string.region_loading)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
            ) {
                DoOverlayLoadingWheel(
                    modifier = Modifier
                        .align(Alignment.Center),
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
    onStoryClick: (Int) -> Unit
) {

    when (calendarState) {
        CalendarStoryUiState.Loading -> Unit
        is CalendarStoryUiState.Success -> {
            Log.d("StoryTest", calendarState.toString())
            MonthlyCalendar(
                year = calendarState.year.toInt(),
                month = calendarState.month.toInt(),
                stories = calendarState.storyCalendarResource.stories[0].posts,
                onStoryClicked = onStoryClick,
                modifier = modifier
            )
        }
    }
}


@Composable
fun RegionView(
    modifier: Modifier = Modifier,
    regionState: RegionStoryUiState,
    onStoryClick: (Int) -> Unit
) {

    when (regionState) {
        RegionStoryUiState.Loading -> Unit
        is RegionStoryUiState.Success -> {

        }
    }
}


@Composable
fun MonthlyCalendar(
    stories: List<Post>,
    onStoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    year: Int,
    month: Int
) {
    val storiesMap = stories.associateBy { LocalDate.parse(it.date) }
    val daysInMonth = YearMonth.of(year, month).lengthOfMonth()
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val daysBefore = firstDayOfMonth.dayOfWeek.value % DAYS_IN_WEEK

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeekdaysRow()
        Spacer(modifier = Modifier.height(8.dp))
        CalendarRows(storiesMap, daysBefore, daysInMonth, year, month, onStoryClicked)
    }
}

@Composable
fun WeekdaysRow(modifier: Modifier = Modifier) {
    val daysInKorean = listOf("월", "화", "수", "목", "금", "토", "일")
    Row(modifier = modifier.fillMaxWidth()) {
        DayOfWeek.values().forEach { dayOfWeek ->
            Text(
                modifier = Modifier.weight(1f),
                text = daysInKorean[dayOfWeek.ordinal],
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall
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
    modifier: Modifier = Modifier
) {
    val totalDays = daysBefore + daysInMonth
    for (i in 0 until totalDays step DAYS_IN_WEEK) {
        Row(modifier = modifier.fillMaxWidth()) {
            for (j in i until i + 7) {
                val day = j - daysBefore + 1
                if (j in daysBefore until daysBefore + daysInMonth) {
                    CalendarItem(
                        day = day,
                        post = storiesMap[LocalDate.of(year, month, day)],
                        onStoryClick = onStoryClicked,
                        modifier = modifier
                            .weight(1f)
                            .size(45.dp)
                            .padding(2.dp)
                    )
                } else {
                    Box(
                        modifier = modifier
                            .weight(1f)
                            .size(45.dp)
                            .padding(2.dp)
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
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val radiusPx = with(density) { 45.dp.toPx() } / 2

    Box(
        modifier = modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFFD9D9D9), Color(0xFFD9D9D9)),
                    radius = radiusPx
                ),
                shape = RoundedIrregularShape()
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "$day", style = MaterialTheme.typography.bodyMedium, color = Color.White)
        post?.let {
            DynamicAsyncImage(
                it.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedIrregularShape())
                    .clickable {
                        onStoryClick(post.postId)
                    }
            )
        }
    }
}

@Composable
fun RoundedIrregularShape(): Shape {
    return object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            return Outline.Generic(
                Path().apply {
                    // Adjusting the path to fit the given size
                    val scaleX = size.width / 46f
                    val scaleY = size.height / 48f

                    moveTo(36.403f * scaleX, 42.868f * scaleY)
                    cubicTo(
                        26.23f * scaleX, 47.249f * scaleY,
                        4.996f * scaleX, 47.898f * scaleY,
                        0.996f * scaleX, 25.536f * scaleY
                    )
                    cubicTo(
                        -0.004f * scaleX, 12.361f * scaleY,
                        8.033f * scaleX, -3.979f * scaleY,
                        32.447f * scaleX, 2.368f * scaleY
                    )
                    cubicTo(
                        51.245f * scaleX, 7.255f * scaleY,
                        51.118f * scaleX, 36.531f * scaleY,
                        36.403f * scaleX, 42.868f * scaleY
                    )
                    close()
                }
            )
        }
    }
}


const val DAYS_IN_WEEK = 7


