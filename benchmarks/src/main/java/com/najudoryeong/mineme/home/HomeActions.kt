package com.najudoryeong.mineme.home

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until

fun MacrobenchmarkScope.homeYouWaitForContent() {
    // "loadingWheel"라는 리소스 ID를 가진 로딩 애니메이션(또는 UI 요소)이 사라질 때까지 최대 5초 동안 대기
    device.wait(Until.gone(By.res("loadingWheel")), 5_000)

    // LoaddingWheel이 사라지더라도 완전히 로드가 되지않을 때 방지
    //device.waitAndFindObject(By.res("home:Main"), 10_000)
}
