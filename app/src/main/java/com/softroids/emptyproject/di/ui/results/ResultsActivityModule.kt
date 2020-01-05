package com.softroids.emptyproject.di.ui.results

import com.softroids.emptyproject.ui.results.ResultsActivity
import com.softroids.emptyproject.ui.results.ResultsActivityViewAccess
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class ResultsActivityModule(private val activity: ResultsActivity) {

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class AcitivityScope

    @Provides
    @AcitivityScope
    fun providesResultsAcitivty(): ResultsActivity {
        return activity
    }

    @Provides
    @AcitivityScope
    fun providesResultsActivityViewAccess(activity: ResultsActivity): ResultsActivityViewAccess {
        return activity
    }
}