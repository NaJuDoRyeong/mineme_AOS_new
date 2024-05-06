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

package com.najudoryeong.mineme.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kimdowoo.datepicker.componenet.SpinnerDatePicker
import com.kimdowoo.datepicker.model.Date

@Composable
fun DateDialog(
    modifier: Modifier = Modifier,
    selectedYear: Int,
    selectedMonth: Int,
    selectedDay: Int,
    updateDate: (Int, Int, Int) -> Unit,
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable { showDialog = true }
            .padding(top = 4.dp),
    ) {
        DateDropdown(modifier = Modifier.weight(1f), text = "${selectedYear}년")
        Spacer(modifier = Modifier.width(4.dp))
        DateDropdown(modifier = Modifier.weight(1f), text = "${selectedMonth}월")
        Spacer(modifier = Modifier.width(4.dp))
        DateDropdown(modifier = Modifier.weight(1f), text = "${selectedDay}일")
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                    ).padding(bottom = 32.dp),
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            text = "완료",
                            modifier = Modifier
                                .padding(24.dp)
                                .clickable {
                                    showDialog = false
                                },
                            color = Color.Black,
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                    SpinnerDatePicker(
                        selectViewEnable = true,
                        startDate = Date(
                            selectedYear,
                            selectedMonth,
                            selectedDay,
                        ),
                    ) { year, month, day ->
                        updateDate(year, month, day)
                    }
                }
            }
        }
    }
}
