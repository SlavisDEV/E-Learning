package com.softroids.emptyproject.di.ui.learning.video

import com.softroids.emptyproject.ui.learning.video.VideoLearningFragment
import dagger.Subcomponent

@VideoLearningFragmentModule.FragmentScope
@Subcomponent(
    modules = [VideoLearningFragmentModule::class]
)
interface VideoLearningFragmentComponent {

    fun inject(fragment: VideoLearningFragment): VideoLearningFragment
}