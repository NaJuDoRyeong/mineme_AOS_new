package com.najudoryeong.mineme.story

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.najudoryeong.mineme.PACKAGE_NAME
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StoryCalendarDateChangeBenchmark {

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
                goToStory()
                changeToCalenderView()
                device.waitForIdle()
            },
        ) {
            repeat(3) {
                changeDateUsingPicker()
            }
        }
}
