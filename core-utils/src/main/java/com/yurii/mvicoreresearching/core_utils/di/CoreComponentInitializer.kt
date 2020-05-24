package com.yurii.mvicoreresearching.core_utils.di

abstract class CoreComponentInitializer<Component> {

    @Volatile private var component: Component? = null

    @Suppress("UNCHECKED_CAST")
    fun <Api> get(): Api {
        return (component ?: synchronized(this) {
            component ?: buildComponent().also { component = it }
        }) as Api
    }

    protected abstract fun buildComponent(): Component

}