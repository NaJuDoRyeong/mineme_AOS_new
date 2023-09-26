package com.najudoryeong.mineme.feature.story

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.najudoryeong.mineme.core.designsystem.component.AnimatedScreen
import com.najudoryeong.mineme.core.designsystem.component.CustomBottomButton
import com.najudoryeong.mineme.core.designsystem.component.DateDialog
import com.najudoryeong.mineme.core.designsystem.component.LocationDropdownMenu
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.ui.R.string
import java.time.LocalDate


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
    val allRegions = viewModel.allRegions.collectAsStateWithLifecycle().value
    val allCities = viewModel.allCities.collectAsStateWithLifecycle().value
    val selectedRegion = viewModel.selectedRegion.collectAsStateWithLifecycle().value
    val selectedCity = viewModel.selectedCity.collectAsStateWithLifecycle().value

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
                    updateDate = viewModel::updateDate,
                    allRegions = allRegions,
                    allCities = allCities,
                    updateRegion = viewModel::updateRegion,
                    updateCity = viewModel::updateCity,
                    updateImage = viewModel::updateImage,
                )
            }
        }
        composable(secondScreenRoute) {
            WriteStorySecondPageScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                onBackClick = navController::popBackStack,
                selectedDate = selectedDate,
                selectedRegion = selectedRegion,
                selectedCity = selectedCity
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
    allRegions: List<String>,
    allCities: List<String>,
    updateRegion: (String) -> Unit,
    updateCity: (String) -> Unit,
    updateImage: (Uri) -> Unit,
) {

    val imagePicker =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                updateImage(uri)
                onContinueClicked()
            }
        }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            text = stringResource(
                R.string.day_pick_title,
            ),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start
        )
        DateDialog(
            selectedYear = selectedDate.year,
            selectedMonth = selectedDate.monthValue,
            selectedDay = selectedDate.dayOfMonth,
            updateDate = updateDate
        )

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            text = stringResource(
                R.string.region_city_pick_title,
            ),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start
        )

        Row {
            LocationDropdownMenu(
                modifier = Modifier
                    .weight(0.5f),
                menuList = allRegions,
                onItemSelected = updateRegion,
            )

            Spacer(modifier = Modifier.width(8.dp))

            LocationDropdownMenu(
                modifier = Modifier
                    .weight(0.5f),
                menuList = allCities,
                onItemSelected = updateCity
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        CustomBottomButton(
            textRes = R.string.choosePicture,
            onClick = {
                imagePicker.launch("image/*")
            }
        )
    }
}

@Composable
fun WriteStorySecondPageScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    selectedDate: LocalDate,
    selectedRegion: String,
    selectedCity: String
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${selectedDate.year} ${selectedDate.monthValue} ${selectedDate.dayOfMonth}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "$selectedRegion ${selectedCity}에서",
                style = MaterialTheme.typography.titleSmall
            )
        }

        Spacer(modifier = Modifier.weight(1f)) //나머지 공간

        CustomBottomButton(textRes = string.complete)
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
            modifier = Modifier.align(Alignment.Center),
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
