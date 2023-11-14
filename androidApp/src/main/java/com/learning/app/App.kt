package com.learning.app

import android.app.Application
import di.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}