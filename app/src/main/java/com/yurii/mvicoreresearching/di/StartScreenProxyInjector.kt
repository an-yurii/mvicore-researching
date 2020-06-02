package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.di.app.AppComponent
import com.yurii.mvicoreresearching.startscreen.di.DaggerStartScreenFeatureDependenciesComponent
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import com.yurii.mvicoreresearching.startscreen_api.StartScreenFeatureApi

object StartScreenProxyInjector {

    fun getFeature(): StartScreenFeatureApi {
        return StartScreenFeatureComponent.Initializer.initAndGet(
            DaggerStartScreenFeatureDependenciesComponent.builder()
                .navigationApi(AppComponent.Initializer.get())
                .build()
        )
    }

}