package com.softroids.emptyproject.di.ui.test

import com.softroids.emptyproject.ui.test.TestActivity
import dagger.Subcomponent

@TestActivityModule.ActivityScope
@Subcomponent(
    modules = [TestActivityModule::class]
)
interface TestActivityComponent {

    fun inject(activity: TestActivity): TestActivity
}
