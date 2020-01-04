package com.softroids.emptyproject.di.ui.learning.audio

import com.softroids.emptyproject.ui.learning.audio.AudioLearningFragment
import com.softroids.emptyproject.ui.learning.audio.AudioLearningFragmentViewAccess
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class AudioLearningFragmentModule(private val fragment: AudioLearningFragment) {

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class FragmentScope

    @Provides
    @FragmentScope
    fun providesAudioLearningFragment(): AudioLearningFragment {
        return fragment
    }

    @Provides
    @FragmentScope
    fun providesAudioLearningFragmentViewAccess(fragment: AudioLearningFragment): AudioLearningFragmentViewAccess {
        return fragment
    }
}