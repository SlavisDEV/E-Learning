package com.softroids.emptyproject.di.base

import com.softroids.emptyproject.di.ui.main.MainActivityComponent
import com.softroids.emptyproject.di.ui.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppSettingsModule::class
    ]
)
interface AppComponent {

    fun plus(module: MainActivityModule): MainActivityComponent
}