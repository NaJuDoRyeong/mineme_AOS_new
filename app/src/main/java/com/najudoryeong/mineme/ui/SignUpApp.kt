package com.najudoryeong.mineme.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.najudoryeong.mineme.core.data.util.NetworkMonitor


@Composable
fun SignUpApp(
    networkMonitor: NetworkMonitor,
    updateJwt: (String) -> Unit,
) {
    Button(onClick = {
        kakaoLogin(updateJwt)
    }) {
        Text(text = "카카오톡으로 로그인")
    }
}

fun kakaoLogin(updateJwt: (String) -> Unit) {
    updateJwt("random")
}