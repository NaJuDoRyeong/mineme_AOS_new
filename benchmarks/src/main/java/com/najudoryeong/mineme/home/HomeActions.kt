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

package com.najudoryeong.mineme.home

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import com.najudoryeong.mineme.waitAndFindObject

fun MacrobenchmarkScope.homeYouWaitForContent() {
    // "loadingWheel"라는 리소스 ID를 가진 로딩 애니메이션(또는 UI 요소)이 사라질 때까지 최대 5초 동안 대기
    device.wait(Until.gone(By.res("loadingWheel")), 5_000)

    device.waitAndFindObject(By.res("CoupleProfile:Image"), 10_000)
}
