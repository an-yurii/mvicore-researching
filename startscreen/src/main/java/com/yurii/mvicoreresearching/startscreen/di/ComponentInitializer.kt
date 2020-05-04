package com.yurii.mvicoreresearching.startscreen.di

abstract class ComponentInitializer<Component, Dependencies> {
    @Volatile private var component: Component? = null

    @Suppress("UNCHECKED_CAST")
    fun <Api> initAndGet(dependencies: Dependencies): Api {
        return (component ?: synchronized(this) {
            component ?: buildComponent(dependencies).also { component = it }
        }) as Api
    }

    fun get(): Component = component ?: throw RuntimeException("Component doesn't initialized")

    fun reset() {
        component = null
    }

    protected abstract fun buildComponent(dependencies: Dependencies): Component

}