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

package com.najudoryeong.mineme

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import com.najudoryeong.mineme.benchmarks.BuildConfig
import java.io.ByteArrayOutputStream
import java.lang.AssertionError

val PACKAGE_NAME = buildString {
    append("com.najudoryeong.mineme")
    append(BuildConfig.APP_FLAVOR_SUFFIX)
    append(BuildConfig.APP_BUILD_TYPE_SUFFIX)
}

fun UiDevice.flingElementDownUp(element: UiObject2) {
    element.setGestureMargin(displayWidth / 5)
    element.fling(Direction.DOWN)
    waitForIdle()
    element.fling(Direction.UP)
}

fun UiDevice.waitAndFindObject(selector: BySelector, timeout: Long): UiObject2 {
    if (!wait(Until.hasObject(selector), timeout)) {
        throw AssertionError("Element not found on screen in ${timeout}ms (selector=$selector")
    }
    return findObject(selector)
}

fun UiDevice.dumpWindowHierarchy(): String {
    val buffer = ByteArrayOutputStream()
    dumpWindowHierarchy(buffer)
    return buffer.toString()
}
