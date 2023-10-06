package com.najudoryeong.mineme.story

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import com.najudoryeong.mineme.flingElementDownUp

fun MacrobenchmarkScope.storyWaitForPost() {
    device.wait(Until.hasObject(By.text("전체")),30_000)
}

fun MacrobenchmarkScope.storyScrollPostDownUp() {
    val postList = device.wait(Until.findObject(By.res("story:posts")), 2_000)
    device.flingElementDownUp(postList)
}


