package com.softroids.emptyproject.ui.learning.audio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.exoplayer2.ui.PlayerView

import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.FragmentAudioLearningBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.learning.audio.AudioLearningFragmentModule
import kotlinx.android.synthetic.main.fragment_video_learning.*
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

    override fun addVideoView(videoView: PlayerView, position: Int) {
        removeVideoView(videoView)

        when (position) {
            0 -> frameLayout_video
            else -> frameLayout_video_1
        }.addView(videoView)
    }

    override fun removeVideoView(videoView: PlayerView) {
        if (videoView.parent != null) {
            (videoView.parent as ViewGroup).removeView(videoView)
        }
    }

    override fun showVideoLoader(position: Int) {
        when (position) {
            0 ->  progressBar_loadVideo
            else ->  progressBar_loadVideo_1
        }.visibility = View.VISIBLE
    }

    override fun hideVideoLoader(position: Int) {
        when (position) {
            0 ->  progressBar_loadVideo
            else ->  progressBar_loadVideo_1
        }.visibility = View.INVISIBLE
    }

    override fun hidePlayVideoButton(position: Int) {
        when (position) {
            0 ->  imageButton_playVideo
            else ->  imageButton_playVideo_1
        }.visibility = View.INVISIBLE
    }

    override fun showPlayVideoButton(position: Int) {
        when (position) {
            0 ->  imageButton_playVideo
            else ->  imageButton_playVideo_1
        }.visibility = View.VISIBLE
    }

    override fun onDetach() {
        super.onDetach()
        model.releasePlayer()
    }

}
