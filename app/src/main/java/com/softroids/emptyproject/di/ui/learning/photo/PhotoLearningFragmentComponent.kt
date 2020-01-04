package com.softroids.emptyproject.di.ui.learning.photo

import com.softroids.emptyproject.ui.learning.photo.PhotoLearningFragment
import dagger.Subcomponent

@PhotoLearningFragmentModule.FragmentScope
@Subcomponent(
    modules = [PhotoLearningFragmentModule::class]
)
interface PhotoLearningFragmentComponent {

    fun inject(fragment: PhotoLearningFragment): PhotoLearningFragment
}