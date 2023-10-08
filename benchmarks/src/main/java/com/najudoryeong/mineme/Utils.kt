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
    // 슬라이드 시 시스템 네비게이션을 트리거하지 않도록 요소의 옆에 마진을 설정
    element.setGestureMargin(displayWidth / 5)
    // 아래로 슬라이드
    element.fling(Direction.DOWN)
    waitForIdle()
    // 위 슬라이드
    element.fling(Direction.UP)

}



// selector을 사용하여 화면상의 객체를 찾는다.
// timeout안에 못 찾으면 Error 반환
fun UiDevice.waitAndFindObject(selector: BySelector, timeout: Long): UiObject2 {
    if (!wait(Until.hasObject(selector), timeout)) {
        throw AssertionError("Element not found on screen in ${timeout}ms (selector=$selector")
    }
    return findObject(selector)
}

// 현재 화면의 윈도우 계층 구조를 문자열로 반환
fun UiDevice.dumpWindowHierarchy(): String {
    val buffer = ByteArrayOutputStream()
    dumpWindowHierarchy(buffer)
    return buffer.toString()
}


