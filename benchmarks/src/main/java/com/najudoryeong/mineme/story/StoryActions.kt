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

package com.najudoryeong.mineme.story

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import com.najudoryeong.mineme.flingElementDownUp
import com.najudoryeong.mineme.waitAndFindObject

fun MacrobenchmarkScope.goToStory() {
    device.waitAndFindObject(By.res("Story"), 3_000).click()
    device.waitForIdle()
}

fun MacrobenchmarkScope.storyWaitForPost() {
    device.wait(Until.hasObject(By.text("경남 창원시")), 3_000)
}

fun MacrobenchmarkScope.goToDetailStory() {
    device.waitAndFindObject(By.text("경남 창원시"), 3_000).click()
    device.waitForIdle()
}

fun MacrobenchmarkScope.changeToCalenderView() {
    device.waitAndFindObject(By.res("Story:ChangeView"), 3_000).click()
    device.waitForIdle()
    device.hasObject(By.text("Story:CalendarView"))
}

fun MacrobenchmarkScope.storyScrollPostDownUp(listTag: String) {
    val postList = device.waitAndFindObject(By.res(listTag), 3_000)
    device.flingElementDownUp(postList)
}

fun MacrobenchmarkScope.selectRegionFromDropdown(regionName: String) {
    device.waitAndFindObject(By.res("RegionDropDown"), 3_000).click()
    device.waitForIdle()

    device.waitAndFindObject(By.text(regionName), 3_000).click()
    device.waitForIdle()
}

fun MacrobenchmarkScope.changeDateUsingPicker() {
    device.waitAndFindObject(By.res("Story:DatePicker"), 3_000).click()
    val pickText = device.waitAndFindObject(By.desc("MonthPicker"), 3_000)

    pickText.parent.scroll(Direction.UP, 0.25f)
    device.waitForIdle()

    device.waitAndFindObject(By.text("확인"), 3_000).click()
    device.waitForIdle()
}
