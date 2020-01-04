package com.softroids.emptyproject.di.ui.learning.video

import com.softroids.emptyproject.ui.learning.video.VideoLearningFragment
import com.softroids.emptyproject.ui.learning.video.VideoLearningFragmentViewAccess
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class VideoLearningFragmentModule(private val fragment: VideoLearningFragment) {

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class FragmentScope

    @Provides
    @FragmentScope
    fun providesVideoLearningFragment(): VideoLearningFragment {
        return fragment
    }

    @Provides
    @FragmentScope
    fun providesVideoLearningFragmentViewAccess(fragment: VideoLearningFragment): VideoLearningFragmentViewAccess {
        return fragment
    }
}