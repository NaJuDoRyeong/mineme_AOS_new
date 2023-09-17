package com.najudoryeong.mineme.feature.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najudoryeong.mineme.core.designsystem.component.DoOverlayLoadingWheel
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.Person
import com.najudoryeong.mineme.core.ui.DevicePreviews
import com.najudoryeong.mineme.core.ui.HomeMainResourcePreviewParameterProvider
import com.najudoryeong.mineme.core.ui.HomeUiState


@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val homeState by viewModel.homeState.collectAsStateWithLifecycle()


    HomeScreen(
        homeState = homeState,
        modifier = modifier
    )

}

@Composable
internal fun HomeScreen(
    homeState: HomeUiState,
    modifier: Modifier = Modifier
) {

    val isHomeLoading = homeState is HomeUiState.Loading

    //TODO REPORT
    //ReportDrawnWhen { !isSyncing && !isOnboardingLoading && !isFeedLoading }


    Box(modifier = modifier.fillMaxSize()) {

        Column(modifier.fillMaxSize()) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .testTag("Home:Main"),
            ) {

                CoupleProfile(
                    modifier = Modifier,
                    homeState = homeState
                )




            }
        }

        AnimatedVisibility(
            visible = isHomeLoading,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight },
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
            ) + fadeOut(),
        ) {
            val loadingContentDescription = stringResource(id = R.string.home_loading)
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
fun CoupleProfile(
    modifier: Modifier,
    homeState: HomeUiState
) {
    Log.d("HomeUiState Is", homeState.toString())
    when (homeState) {
        HomeUiState.Loading -> Unit
        is HomeUiState.Success -> {
            Row(modifier) {
                Profile(profileInfo = homeState.homeMainResource.couple.me)
                Profile(profileInfo = homeState.homeMainResource.couple.mine)
            }
        }
    }
}

@Composable
fun Profile(
    profileInfo : Person,
    modifier: Modifier = Modifier
){



}




@DevicePreviews
@Composable
fun HomeScreenSuccessPreview(
    @PreviewParameter(HomeMainResourcePreviewParameterProvider::class)
    homeMainResource : HomeMainResource
) {
    DoTheme {
        HomeScreen(
            homeState = HomeUiState.Success(
                homeMainResource = homeMainResource
            )
        )
    }
}

@DevicePreviews
@Composable
fun HomeScreenLoadingPreview(
    @PreviewParameter(HomeMainResourcePreviewParameterProvider::class)
    homeMainResource : HomeMainResource
) {
    DoTheme {
        HomeScreen(
            homeState = HomeUiState.Loading
        )
    }
}