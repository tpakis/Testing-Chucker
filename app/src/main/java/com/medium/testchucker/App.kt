package com.medium.testchucker

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setupChuckerErrors()
    }

    private fun setupChuckerErrors() {
        if (BuildConfig.DEBUG) {
            val systemHandler = Thread.getDefaultUncaughtExceptionHandler()
            Thread.setDefaultUncaughtExceptionHandler(CustomCrashHandler(systemHandler, this))
        }
    }
}