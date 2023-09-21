package com.najudoryeong.mineme.feature.story

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.ui.CalendarStoryUiState
import com.najudoryeong.mineme.core.ui.RegionStoryUiState
import java.time.LocalDate
import java.time.YearMonth


@Composable
internal fun StoryRoute(
    modifier: Modifier = Modifier,
    viewModel: StoryViewModel = hiltViewModel(),
) {

    val shouldShowCalendar by viewModel.shouldShowCalendar.collectAsStateWithLifecycle()
    val regionState by viewModel.regionState.collectAsStateWithLifecycle()
    val calendarState by viewModel.calendarState.collectAsStateWithLifecycle()

    StoryScreen(
        modifier = modifier,
        shouldShowCalendar = shouldShowCalendar,
        regionState = regionState,
        calendarState = calendarState
    )
}

@Composable
internal fun StoryScreen(
    modifier: Modifier = Modifier,
    shouldShowCalendar: Boolean,
    regionState: RegionStoryUiState,
    calendarState: CalendarStoryUiState
) {

    val isRegionLoading = regionState is RegionStoryUiState.Loading
    val isCalendarLoading = calendarState is CalendarStoryUiState.Loading

    Box(modifier.fillMaxSize()) {

        if (shouldShowCalendar) {
            CalendarView(
                calendarState = calendarState
            )
        } else {
            RegionView(
                regionState = regionState
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
    calendarState: CalendarStoryUiState
) {

    when (calendarState) {
        CalendarStoryUiState.Loading -> Unit
        is CalendarStoryUiState.Success -> {



        }
    }

}


@Composable
fun RegionView(
    modifier: Modifier = Modifier,
    regionState: RegionStoryUiState
) {

    when(regionState) {
        RegionStoryUiState.Loading -> Unit
        is RegionStoryUiState.Success -> {

        }
    }
}


@Composable
fun MonthlyCalendar(
    year: Int,
    month: Int,
    calendarUiState: CalendarUiState,
    onDateClicked: (LocalDate) -> Unit
) {
    val daysInMonth = YearMonth.of(year, month).lengthOfMonth()
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val daysBefore = firstDayOfMonth.dayOfWeek.value % 7

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 요일 헤더
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DayOfWeek.values().forEach { dayOfWeek ->
                Text(text = dayOfWeek.name.take(3), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 날짜
        val totalDays = daysBefore + daysInMonth
        for (i in 0 until totalDays step 7) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (j in i until i + 7) {
                    if (j < daysBefore || j >= daysBefore + daysInMonth) {
                        Text(text = "", modifier = Modifier.weight(1f))
                    } else {
                        val day = j - daysBefore + 1
                        val date = LocalDate.of(year, month, day)
                        val isSelected = calendarUiState.isDateInSelectedPeriod(date)
                        Text(
                            text = "$day",
                            modifier = Modifier.weight(1f).clickable {
                                onDateClicked(date)
                            },
                            color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                        )
                    }
                }
            }
        }
    }
}
