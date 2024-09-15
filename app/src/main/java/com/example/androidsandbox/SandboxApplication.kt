package com.example.androidsandbox

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SandboxApplication : Application()  {
    override fun onCreate() {
        super.onCreate()
    }
}