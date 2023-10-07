package com.najudoryeong.mineme.story

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import com.najudoryeong.mineme.flingElementDownUp

fun MacrobenchmarkScope.storyWaitForPost() {
    device.wait(Until.hasObject(By.text("경남 창원시")), 3_000)
}

fun MacrobenchmarkScope.storyScrollPostDownUp() {
    val postList = device.wait(Until.findObject(By.res("story:posts")), 3_000)
    device.flingElementDownUp(postList)
}


fun MacrobenchmarkScope.selectRegionFromDropdown(regionName: String) {
    val regionDropdown = device.wait(Until.findObject(By.res("RegionDropDown")), 3_000)
    regionDropdown.click()
    device.waitForIdle()

    val menuItem = device.wait(Until.findObject(By.text(regionName)), 3_000)
    menuItem.click()
    device.waitForIdle()
}
