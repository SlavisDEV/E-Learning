package com.softroids.emptyproject.ui.learning.audio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.FragmentAudioLearningBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.learning.audio.AudioLearningFragmentModule
import javax.inject.Inject

class AudioLearningFragment : Fragment(), AudioLearningFragmentViewAccess {

    private lateinit var binding: FragmentAudioLearningBinding

    @Inject
    protected lateinit var model: AudioLearningFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        App.get(activity!!)
            .getAppComponent()
            .plus(AudioLearningFragmentModule(this))
            .inject(this)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_audio_learning, null, false)
        binding.apply {
            lifecycleOwner = this@AudioLearningFragment
            model = this@AudioLearningFragment.model
            viewAccess = this@AudioLearningFragment
        }

        return binding.root
    }


}
