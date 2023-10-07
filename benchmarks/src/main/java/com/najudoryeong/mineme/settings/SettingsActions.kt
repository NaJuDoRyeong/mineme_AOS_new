package com.najudoryeong.mineme.settings

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until


fun MacrobenchmarkScope.goToSettingsScreen() {
    device.findObject(By.res("Settings")).click()
    device.waitForIdle()
    device.wait(Until.hasObject(By.res("DoTopAppBar")), 2_000)
    val topAppBar = device.findObject(By.res("DoTopAppBar"))
    topAppBar.wait(Until.hasObject(By.text("Settings")), 2_000)
}
