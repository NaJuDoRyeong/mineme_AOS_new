package com.najudoryeong.mineme.feature.story

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.najudoryeong.mineme.core.designsystem.component.DynamicAsyncImage
import com.najudoryeong.mineme.core.designsystem.component.Indicator
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
    val selectedImages = viewModel.selectedImage.collectAsStateWithLifecycle().value

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
                    updateImages = viewModel::updateImages,
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
                selectedCity = selectedCity,
                selectedImages = selectedImages,
                storyContent = viewModel.storyContent,
                firstOnBackClick = firstOnBackClick,
                completeWriteStory = { }
            )
        }
    }
}

@Composable
fun WriteStoryFirstPageScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit = {},
    onBackClick: () -> Unit = {},
    selectedDate: LocalDate,
    updateDate: (Int, Int, Int) -> Unit = {_,_,_ ->  },
    allRegions: List<String> = emptyList(),
    allCities: List<String> = emptyList(),
    updateRegion: (String) -> Unit = {},
    updateCity: (String) -> Unit = {},
    updateImages: (List<Uri>) -> Unit = {},
) {

    val imagePicker =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetMultipleContents()) { uris: List<Uri> ->
            if (uris.isNotEmpty()) {
                updateImages(uris)
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
    onBackClick: () -> Unit = {},
    selectedDate: LocalDate,
    selectedRegion: String,
    selectedCity: String,
    selectedImages: List<Uri>,
    completeWriteStory: () -> Unit = {},
    firstOnBackClick: () -> Unit = {},
    storyContent: MutableState<String>

) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(onBackClick = onBackClick)

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

        Spacer(modifier = Modifier.height(8.dp))

        if (selectedImages.isNotEmpty()) {
            ImageSlider(images = selectedImages)
        }

        OutlinedTextField(
            value = storyContent.value,
            onValueChange = { newValue -> storyContent.value = newValue },
            label = { Text(text = stringResource(R.string.story_content_placeholder)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .weight(1f)
        )

        CustomBottomButton(textRes = string.complete,
            onClick = {
                completeWriteStory()
                firstOnBackClick()
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(
    images: List<Uri>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()

    Box(modifier = modifier.padding(top = 16.dp)) {
        HorizontalPager(state = pagerState, pageCount = images.size) { page ->
            val imageUri = images[page]
            DynamicAsyncImage(
                imageUrl = imageUri.toString(),
                contentDescription = null,
                modifier = Modifier.aspectRatio(1f)
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(images.size) { index ->
                Indicator(isSelected = index == pagerState.currentPage)
            }
        }
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
