package com.yurii.mvicoreresearching.di.app

import com.yurii.mvicoreresearching.MainActivity
import com.yurii.mvicoreresearching.application_api.ApplicationApi
import com.yurii.mvicoreresearching.application_api.NavigationApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NavigationModule::class, ScreenModule::class])
@Singleton
abstract class AppComponent : ApplicationApi, NavigationApi {

    object Initializer {
        @Volatile private var component: AppComponent? = null

        fun init(component: AppComponent) {
            if (this.component != null) {
                throw IllegalStateException("AppComponent is already initialized")
            }
            this.component = component
        }

        fun get(): AppComponent = component ?: throw IllegalStateException("AppComponent doesn't initialized")
    }

    abstract fun inject(activity: MainActivity)

}