package com.najudoryeong.mineme.core.designsystem.component

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

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
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))  // 이 부분을 추가합니다.
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
