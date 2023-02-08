package com.example.buttomnavigationexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FundIndiaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}