package com.najudoryeong.mineme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.najudoryeong.mineme.R
import com.najudoryeong.mineme.core.designsystem.component.CustomBottomButton
import com.najudoryeong.mineme.core.ui.DevicePreviews


@Composable
fun SignUpApp(
    modifier: Modifier = Modifier,
    updateJwt: (String) -> Unit,
) {
    Column(
        modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(64.dp))
        CustomBottomButton(
            onClick = { updateJwt("random") },
            textRes = R.string.kakao_signup,
            containerColor = Color(0xFFFFE55F)
        )

    }
}

@DevicePreviews
@Composable
fun SignUpAppPreview() {
    SignUpApp(
        updateJwt = {}
    )
}
