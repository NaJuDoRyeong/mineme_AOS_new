package com.najudoryeong.mineme.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun CustomBottomButton(
    modifier: Modifier = Modifier,
    @StringRes textRes: Int,
    enabled: Boolean = true,
    containerColor: Color = Color(0xFFFFDB94),
    disabledContainerColor: Color = Color.White,
    onClick: () -> Unit = {}
) {

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor
        )
    ) {
        Text(
            text = stringResource(id = textRes),
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
    }

}