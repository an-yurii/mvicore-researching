package com.yurii.mvicoreresearching.di.app

import com.yurii.mvicoreresearching.application_api.ApplicationApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
abstract class AppComponent : ApplicationApi {

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

}