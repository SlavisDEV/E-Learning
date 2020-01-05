package com.softroids.emptyproject.di.ui.results

import com.softroids.emptyproject.ui.results.ResultsActivity
import dagger.Subcomponent

@ResultsActivityModule.AcitivityScope
@Subcomponent(
    modules = [ResultsActivityModule::class]
)
interface ResultsActivityComponent {

    fun inject(activity: ResultsActivity): ResultsActivity
}