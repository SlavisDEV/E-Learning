package com.softroids.emptyproject.di.base

import com.softroids.emptyproject.di.ui.learning.audio.AudioLearningFragmentComponent
import com.softroids.emptyproject.di.ui.learning.audio.AudioLearningFragmentModule
import com.softroids.emptyproject.di.ui.learning.photo.PhotoLearningFragmentComponent
import com.softroids.emptyproject.di.ui.learning.photo.PhotoLearningFragmentModule
import com.softroids.emptyproject.di.ui.learning.video.VideoLearningFragmentComponent
import com.softroids.emptyproject.di.ui.learning.video.VideoLearningFragmentModule
import com.softroids.emptyproject.di.ui.results.ResultsActivityComponent
import com.softroids.emptyproject.di.ui.results.ResultsActivityModule
import com.softroids.emptyproject.di.ui.test.TestActivityComponent
import com.softroids.emptyproject.di.ui.test.TestActivityModule
import com.softroids.emptyproject.ui.results.ResultsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppSettingsModule::class,
        QuizManagerModule::class
    ]
)
interface AppComponent {

//    fun plus(module: LearningActivityModule): LearningActivityComponent

    fun plus(module: PhotoLearningFragmentModule): PhotoLearningFragmentComponent

    fun plus(module: VideoLearningFragmentModule): VideoLearningFragmentComponent

    fun plus(module: AudioLearningFragmentModule): AudioLearningFragmentComponent

    fun plus(module: TestActivityModule): TestActivityComponent

    fun plus(module: ResultsActivityModule): ResultsActivityComponent
}