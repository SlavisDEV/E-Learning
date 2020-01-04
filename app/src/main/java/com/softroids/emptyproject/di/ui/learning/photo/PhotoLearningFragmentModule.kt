package com.softroids.emptyproject.di.ui.learning.photo

import com.softroids.emptyproject.ui.learning.photo.PhotoLearningFragment
import com.softroids.emptyproject.ui.learning.photo.PhotoLearningFragmentViewAccess
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class PhotoLearningFragmentModule(private val fragment: PhotoLearningFragment) {

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class FragmentScope

    @Provides
    @FragmentScope
    fun providesPhotoLearningFragment(): PhotoLearningFragment {
        return fragment
    }

    @Provides
    @FragmentScope
    fun providesPhotoLearningFragmentViewAccess(fragment: PhotoLearningFragment): PhotoLearningFragmentViewAccess {
        return fragment
    }
}