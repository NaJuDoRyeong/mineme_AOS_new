package com.najudoryeong.mineme.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun DateDialog(
    selectedYear: Int, selectedMonth: Int, selectedDay: Int, updateDate: (Int, Int, Int) -> Unit
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { showDialog = true }
            .padding(top = 16.dp)) {
        Text(text = "$selectedYear / $selectedMonth / $selectedDay")
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown Arrow",
            modifier = Modifier.padding(start = 8.dp)
        )
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(16.dp),
            ) {
                Text(
                    text = "날짜 선택",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val yearList = remember { (1950..2023).map { it.toString() } }
                    val yearPickerState = rememberPickerState()
                    val startIndexYear = yearList.indexOf(
                        selectedYear.toString()
                    )

                    val monthList = remember { (1..12).map { String.format("%02d", it) } }
                    val monthPickerState = rememberPickerState()
                    val startIndexMonth = monthList.indexOf(String.format("%02d", selectedMonth))


                    val dayList = remember(selectedYear, selectedMonth) {
                        (1..getDaysInMonth(selectedYear, selectedMonth)).map {
                            String.format(
                                "%02d",
                                it
                            )
                        }
                    }
                    val dayPickerState = rememberPickerState()
                    val startIndexDay = dayList.indexOf(String.format("%02d", selectedDay))


                    Row(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Picker(
                                state = yearPickerState,
                                items = yearList,
                                visibleItemsCount = 3,
                                modifier = Modifier.weight(1f),
                                textModifier = Modifier.padding(8.dp),
                                startIndex = startIndexYear
                            )
                            Picker(
                                state = monthPickerState,
                                items = monthList,
                                visibleItemsCount = 3,
                                modifier = Modifier.weight(1f),
                                textModifier = Modifier.padding(8.dp),
                                startIndex = startIndexMonth
                            )
                            Picker(
                                state = dayPickerState,
                                items = dayList,
                                visibleItemsCount = 3,
                                modifier = Modifier.weight(1f),
                                textModifier = Modifier.padding(8.dp),
                                startIndex = startIndexDay
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        TextButton(
                            onClick = { showDialog = false }, modifier = Modifier.weight(1f)
                        ) {
                            Text("취소")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(
                            onClick = {
                                updateDate(
                                    yearPickerState.selectedItem.toInt(),
                                    monthPickerState.selectedItem.toInt(),
                                    dayPickerState.selectedItem.toInt()
                                )
                                showDialog = false
                            }, modifier = Modifier.weight(1f)
                        ) {
                            Text("확인")
                        }
                    }
                }
            }
        }
    }
}


private fun getDaysInMonth(year: Int, month: Int): Int {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
        else -> throw IllegalArgumentException("Invalid month: $month")
    }
}