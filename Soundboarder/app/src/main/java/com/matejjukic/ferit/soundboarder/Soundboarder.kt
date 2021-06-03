package com.matejjukic.ferit.soundboarder

import android.app.Application
import com.matejjukic.ferit.soundboarder.di.appModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Soundboarder : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Soundboarder)
            modules(appModule)
        }
    }
}