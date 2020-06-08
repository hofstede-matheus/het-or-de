package com.hofstedematheus.hetorde.core

import android.app.Application
import com.hofstedematheus.hetorde.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApplication)
            modules(androidModule)
        }
    }

}