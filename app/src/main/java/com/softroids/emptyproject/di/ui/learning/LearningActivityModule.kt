//package com.softroids.emptyproject.di.ui.learning
//
//import com.softroids.emptyproject.ui.learning.LearningActivity
//import com.softroids.emptyproject.ui.learning.LearningActivityViewAccess
//import dagger.Module
//import dagger.Provides
//import javax.inject.Scope
//
//@Module
//class LearningActivityModule(private val activity: LearningActivity) {
//
//    @Scope
//    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
//    annotation class ActivityScope
//
//    @Provides
//    @ActivityScope
//    fun providesLearningActivity(): LearningActivity {
//        return activity
//    }
//
//    @Provides
//    @ActivityScope
//    fun providesLearningActivityViewAccess(activity: LearningActivity): LearningActivityViewAccess {
//        return activity
//    }
//
//}