package com.yurii.mvicoreresearching

import android.app.Application
import android.content.Context
import com.yurii.mvicoreresearching.di.app.AppComponent
import com.yurii.mvicoreresearching.di.app.DaggerAppComponent

class MviCoreApplication : Application() {

    companion object {
        private lateinit var appContext: Context
        fun getAppContext(): Context = appContext
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.Initializer.init(DaggerAppComponent.builder().build())
    }
}