package com.najudoryeong.mineme.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import com.najudoryeong.mineme.PACKAGE_NAME
import com.najudoryeong.mineme.home.homeYouWaitForContent
import org.junit.Rule
import org.junit.Test

class BaselineProfileGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun generate() = baselineProfileRule.collect(PACKAGE_NAME) {
            pressHome()
            startActivityAndWait()
            homeYouWaitForContent()
        }

}