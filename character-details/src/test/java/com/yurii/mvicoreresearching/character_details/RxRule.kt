package com.yurii.mvicoreresearching.character_details

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RxRule : TestRule {

    var schedulerForTest: Scheduler
        private set
    var taskSchedulerForTest: Scheduler
        private set

    constructor() {
        schedulerForTest = Schedulers.trampoline()
        taskSchedulerForTest = schedulerForTest
    }

    constructor(scheduler: Scheduler = Schedulers.trampoline(), taskScheduler: Scheduler? = null) {
        this.schedulerForTest = scheduler
        taskSchedulerForTest = taskScheduler ?: scheduler
    }

    override fun apply(base: Statement, description: Description): Statement {
        return statement(base)
    }

    protected fun after() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

    protected fun before() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { schedulerForTest }
        RxAndroidPlugins.setMainThreadSchedulerHandler { schedulerForTest }
        RxJavaPlugins.setIoSchedulerHandler { schedulerForTest }
        RxJavaPlugins.setNewThreadSchedulerHandler { schedulerForTest }
        RxJavaPlugins.setComputationSchedulerHandler { schedulerForTest }
    }

    private fun statement(base: Statement): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                before()
                try {
                    base.evaluate()
                } finally {
                    after()
                }
            }
        }
    }
}
