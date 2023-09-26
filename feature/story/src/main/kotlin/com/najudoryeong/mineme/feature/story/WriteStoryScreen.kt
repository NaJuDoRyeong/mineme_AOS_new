package com.najudoryeong.mineme.feature.story

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.najudoryeong.mineme.core.designsystem.icon.DoIcons
import com.najudoryeong.mineme.core.ui.R.string

@Composable
internal fun WriteStoryRoute(
    modifier: Modifier = Modifier,
    viewModel: WriteStoryViewModel = hiltViewModel(),
    firstOnBackClick: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "write_story_first_page") {
        composable("write_story_first_page") {
            WriteStoryFirstPageScreen(
                viewModel = viewModel,
                onContinueClicked = { navController.navigate("write_story_second_page") },
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                onBackClick = firstOnBackClick
            )
        }
        composable("write_story_second_page") {
            WriteStorySecondPageScreen(
                viewModel = viewModel, modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                onBackClick = navController::popBackStack
            )
        }
    }
}

@Composable
fun WriteStoryFirstPageScreen(
    viewModel: WriteStoryViewModel,
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.weight(1f)) // 이 Spacer가 나머지 공간을 모두 차지합니다.

        Button(onClick = onContinueClicked) {
            Text("Continue")
        }
    }
}

@Composable
fun WriteStoryToolBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "스토리 작성",
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


@Composable
fun WriteStorySecondPageScreen(
    viewModel: WriteStoryViewModel,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Column(modifier = modifier.fillMaxSize()) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))

        WriteStoryToolBar(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.weight(1f)) // 이 Spacer가 나머지 공간을 모두 차지합니다.

        Text(text = "second")
    }

}
