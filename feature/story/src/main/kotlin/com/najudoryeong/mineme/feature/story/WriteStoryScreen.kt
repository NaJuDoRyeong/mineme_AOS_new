package com.najudoryeong.mineme.feature.story

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.najudoryeong.mineme.core.designsystem.component.AnimatedScreen
import com.najudoryeong.mineme.core.designsystem.component.DateDialog
import com.najudoryeong.mineme.core.designsystem.component.Picker
import com.najudoryeong.mineme.core.designsystem.component.rememberPickerState
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.ui.R.string
import java.time.LocalDate
import kotlin.reflect.KFunction3


const val firstScreenRoute = "write_story_first_page"
const val secondScreenRoute = "write_story_second_page"

@Composable
internal fun WriteStoryRoute(
    modifier: Modifier = Modifier,
    viewModel: WriteStoryViewModel = hiltViewModel(),
    firstOnBackClick: () -> Unit,
) {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val selectedDate = viewModel.selectedDate.collectAsStateWithLifecycle().value

    NavHost(navController, startDestination = firstScreenRoute) {
        composable(firstScreenRoute) {
            AnimatedScreen(
                isVisible = currentRoute == firstScreenRoute
            ) {
                WriteStoryFirstPageScreen(
                    onContinueClicked = { navController.navigate(secondScreenRoute) },
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    onBackClick = firstOnBackClick,
                    selectedDate = selectedDate,
                    updateDate = viewModel::updateDate
                )
            }
        }
        composable(secondScreenRoute) {
            WriteStorySecondPageScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                onBackClick = navController::popBackStack
            )
        }
    }
}

@Composable
fun WriteStoryFirstPageScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    selectedDate: LocalDate,
    updateDate: (Int, Int, Int) -> Unit,
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        DateDialog(
            selectedYear = selectedDate.year,
            selectedMonth = selectedDate.monthValue,
            selectedDay = selectedDate.dayOfMonth,
            updateDate = updateDate
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onContinueClicked) {
            Text("Continue")
        }
    }
}

@Composable
fun WriteStorySecondPageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.weight(1f)) // 이 Spacer가 나머지 공간을 모두 차지합니다.

        Text(text = "second")
    }

}


@Composable
fun WriteStoryToolBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(id = R.string.writeStory),
            modifier = Modifier.align(Alignment.Center)
        )

        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = DoIcons.ArrowBack,
                contentDescription = stringResource(
                    id = string.back,
                ),
            )
        }
    }
}