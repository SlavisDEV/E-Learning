package com.softroids.emptyproject.di.ui.test

import com.softroids.emptyproject.ui.test.TestActivity
import com.softroids.emptyproject.ui.test.TestActivityViewAccess
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class TestActivityModule(private val activity: TestActivity) {

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ActivityScope

    @Provides
    @ActivityScope
    fun providesTestActivity(): TestActivity {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesTestActivityViewAccess(activity: TestActivity): TestActivityViewAccess {
        return activity
    }
}