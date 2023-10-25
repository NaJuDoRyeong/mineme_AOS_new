package com.najudoryeong.mineme.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.najudoryeong.mineme.core.designsystem.theme.LocalBackgroundTheme

@Composable
fun DoBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {

    // LocalBackgroundTheme: 현재 설정된 배경의 색상(color)과 음영(tonalElevation)을 가져옵니다.
    val color = LocalBackgroundTheme.current.color
    val tonalElevation = LocalBackgroundTheme.current.tonalElevation


    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        tonalElevation = if (tonalElevation == Dp.Unspecified) 0.dp else tonalElevation,
        modifier = modifier.fillMaxSize(),
    ) {

        // ocalAbsoluteTonalElevation: 음영을 위한 절대적인 높이 값을 설정합니다. 0.dp로 초기화
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}
