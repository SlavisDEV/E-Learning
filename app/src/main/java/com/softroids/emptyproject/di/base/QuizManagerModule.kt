package com.softroids.emptyproject.di.base

import com.softroids.emptyproject.data.QuizManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class QuizManagerModule {

    @Provides
    fun providesQuizManager(): QuizManager{
        return QuizManager()
    }
}