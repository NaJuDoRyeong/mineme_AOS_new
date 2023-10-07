package com.najudoryeong.mineme.story

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import com.najudoryeong.mineme.PACKAGE_NAME
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

internal val dropdownRegion = listOf("경남","서울","부산")

@RunWith(AndroidJUnit4::class)
class RegionStoryRecompositionBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()


    @Test
    fun benchmarkStateChangeCompilationBaselineProfile() =
        benchmarkStateChange(CompilationMode.Partial())


    private fun benchmarkStateChange(compilationMode: CompilationMode) =
        benchmarkRule.measureRepeated(
            packageName = PACKAGE_NAME,
            metrics = listOf(FrameTimingMetric()),
            compilationMode = compilationMode,
            iterations = 10,
            startupMode = StartupMode.WARM,
            setupBlock = {
                pressHome()
                startActivityAndWait()
                device.waitForIdle()
                device.findObject(By.res("Story")).click()
            },
        ) {
            storyWaitForPost()
            repeat(3) {
                selectRegionFromDropdown(dropdownRegion[it])
            }
        }
}