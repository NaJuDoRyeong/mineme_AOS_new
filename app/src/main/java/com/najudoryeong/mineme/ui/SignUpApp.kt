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

package com.najudoryeong.mineme.ui

import androidx.compose.foundation.layout.Arrangement
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

/**
 * todo : backEnd에 AccessToken을 받는 로직이 완성되면 jwt를 받아 저장하는 로직 구현
 */
@Composable
fun SignUpApp(
    modifier: Modifier = Modifier,
    updateJwt: (String) -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AppNameText()
        Spacer(modifier = Modifier.height(64.dp))
        SignUpButton(updateJwt)
    }
}

@Composable
fun AppNameText() {
    Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun SignUpButton(updateJwt: (String) -> Unit) {
    CustomBottomButton(
        onClick = { updateJwt("random") },
        textRes = R.string.kakao_signup,
        containerColor = Color(0xFFFFE55F),
    )
}

@DevicePreviews
@Composable
fun SignUpAppPreview() {
    SignUpApp(
        updateJwt = {},
    )
}
