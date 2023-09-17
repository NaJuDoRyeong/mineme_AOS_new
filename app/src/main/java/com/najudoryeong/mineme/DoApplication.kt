package com.najudoryeong.mineme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DoApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }


}