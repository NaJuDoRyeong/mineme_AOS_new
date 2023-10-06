package com.najudoryeong.mineme.startup

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.najudoryeong.mineme.PACKAGE_NAME
import com.najudoryeong.mineme.home.homeYouWaitForContent
import com.najudoryeong.mineme.setTestJwtAndStartApp
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class StartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startupNoCompilation() = startup(CompilationMode.None())
    /**
    @Test
    fun startupBaselineProfileDisabled() = startup(
        CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Disable, warmupIterations = 1),
    )

    @Test
    fun startupBaselineProfile() = startup(CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Require))

    @Test
    fun startupFullCompilation() = startup(CompilationMode.Full())
**/
    private fun startup(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = PACKAGE_NAME,
        metrics = listOf(StartupTimingMetric()),
        compilationMode = compilationMode,
        iterations = 10,
        startupMode = StartupMode.COLD,
        setupBlock = {
            pressHome()
        },
    ) {
        startActivityAndWait()
        homeYouWaitForContent()
    }
}

