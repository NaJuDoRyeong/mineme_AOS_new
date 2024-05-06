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

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.najudoryeong.mineme.core.designsystem.component.AnimatedScreen
import com.najudoryeong.mineme.core.designsystem.component.CustomBottomButton
import com.najudoryeong.mineme.core.designsystem.component.DateDialog
import com.najudoryeong.mineme.core.designsystem.component.DoTextButton
import com.najudoryeong.mineme.core.designsystem.component.ImageSlider
import com.najudoryeong.mineme.core.designsystem.component.LocationDropdownMenu
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.ui.R.string
import com.najudoryeong.mineme.feature.story.util.readImageMetadata
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
                isVisible = currentRoute == firstScreenRoute,
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
                    selectedRegion = selectedRegion,
                    selectedCity = selectedCity,
                    updateRegion = viewModel::updateRegion,
                    updateCity = viewModel::updateCity,
                    updateImages = viewModel::updateImages,
                    updateLocation = viewModel::updateLocation,
                    selectedImages = selectedImages,
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
                completeWriteStory = { },
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
    updateDate: (Int, Int, Int) -> Unit = { _, _, _ -> },
    allRegions: List<String> = emptyList(),
    allCities: List<String> = emptyList(),
    updateRegion: (String) -> Unit = {},
    updateCity: (String) -> Unit = {},
    updateImages: (List<Uri>) -> Unit = {},
    updateLocation: (String, String) -> Unit = { _, _ -> },
    selectedImages: List<Uri>,
    selectedCity: String,
    selectedRegion: String,
) {
    val context = LocalContext.current

    val hasPermission by remember {
        val isGranted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
        mutableStateOf(isGranted)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (!isGranted) {
                Toast.makeText(
                    context,
                    context.getString(R.string.access_media_location), Toast.LENGTH_LONG,
                ).show()
            }
        },
    )

    val imagePicker =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetMultipleContents()) { uris: List<Uri> ->
            if (uris.isNotEmpty()) {
                updateImages(uris)
                uris.firstOrNull()?.let { uri ->
                    readImageMetadata(
                        uri = uri,
                        context = context,
                        updateDate = updateDate,
                        updateLocation = updateLocation,
                    )
                }
            } else {
                onBackClick()
            }
        }

    LaunchedEffect(Unit) {
        if (!hasPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) permissionLauncher.launch(
            Manifest.permission.ACCESS_MEDIA_LOCATION,
        )
        if (selectedImages.isEmpty()) imagePicker.launch("image/*")
    }

    if (selectedImages.isNotEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

            WriteStoryToolBar(onBackClick = onBackClick)

            ImageSlider(images = selectedImages)

            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                text = "이때가 맞나요?",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
            )

            DateDialog(
                selectedYear = selectedDate.year,
                selectedMonth = selectedDate.monthValue,
                selectedDay = selectedDate.dayOfMonth,
                updateDate = updateDate,
            )

            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                text = "여기가 맞나요?",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
            )

            Row {
                LocationDropdownMenu(
                    modifier = Modifier.weight(0.5f),
                    menuList = allRegions,
                    onItemSelected = updateRegion,
                    selectedLocation = selectedRegion,
                )

                Spacer(modifier = Modifier.width(8.dp))

                LocationDropdownMenu(
                    modifier = Modifier.weight(0.5f),
                    menuList = allCities,
                    onItemSelected = updateCity,
                    selectedLocation = selectedCity,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            CustomBottomButton(
                textRes = R.string.next_writeStory,
                onClick = onContinueClicked,
            )
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
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
    storyContent: MutableState<String>,
) {

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(onBackClick = onBackClick)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "${selectedDate.year}년 ${selectedDate.monthValue}월 ${selectedDate.dayOfMonth}일",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "$selectedRegion ${selectedCity}에서",
                style = MaterialTheme.typography.titleSmall,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (selectedImages.isNotEmpty()) {
            ImageSlider(images = selectedImages)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
                .weight(1f)
                .clickable { showDialog = true },
        ) {
            OutlinedTextField(
                value = storyContent.value,
                onValueChange = { },
                readOnly = true,
                enabled = false,
                label = { Text(text = stringResource(R.string.story_content_placeholder)) },
                modifier = Modifier.fillMaxSize(),
            )
        }


        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Column {
                    OutlinedTextField(
                        value = storyContent.value,
                        onValueChange = { newValue -> storyContent.value = newValue },
                        label = { Text(text = stringResource(R.string.story_content_placeholder)) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor = MaterialTheme.colorScheme.onSecondary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onSecondary,
                            disabledBorderColor = MaterialTheme.colorScheme.onSecondary,
                            disabledPlaceholderColor = MaterialTheme.colorScheme.onSecondary,
                            cursorColor = MaterialTheme.colorScheme.onSecondary,
                            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSecondary,
                            focusedPlaceholderColor = MaterialTheme.colorScheme.onSecondary,
                            disabledLabelColor = MaterialTheme.colorScheme.onSecondary,
                            focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                            unfocusedLabelColor = MaterialTheme.colorScheme.onSecondary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(vertical = 8.dp),
                        )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        DoTextButton(
                            onClick = {
                                showDialog = false
                            },
                        ) {
                            Text(
                                "확인",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }

        CustomBottomButton(
            textRes = string.complete,
            onClick = {
                completeWriteStory()
                firstOnBackClick()
            },
        )
        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
    }
}


@Composable
fun WriteStoryToolBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = stringResource(id = R.string.writeStory),
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleLarge,
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
