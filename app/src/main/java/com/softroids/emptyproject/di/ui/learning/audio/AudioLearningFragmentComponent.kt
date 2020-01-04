package com.softroids.emptyproject.di.ui.learning.audio

import com.softroids.emptyproject.ui.learning.audio.AudioLearningFragment
import dagger.Subcomponent

@AudioLearningFragmentModule.FragmentScope
@Subcomponent(
    modules = [AudioLearningFragmentModule::class]
)
interface AudioLearningFragmentComponent {

    fun inject(fragment: AudioLearningFragment): AudioLearningFragment
}