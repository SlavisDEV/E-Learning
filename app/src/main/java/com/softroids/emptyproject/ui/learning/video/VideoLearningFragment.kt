package com.softroids.emptyproject.ui.learning.video


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.FragmentVideoLearningBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.learning.video.VideoLearningFragmentModule
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class VideoLearningFragment : Fragment(), VideoLearningFragmentViewAccess {

    private lateinit var binding: FragmentVideoLearningBinding

    @Inject
    protected lateinit var model: VideoLearningFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        App.get(activity!!)
            .getAppComponent()
            .plus(VideoLearningFragmentModule(this))
            .inject(this)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_video_learning, null, false)
        binding.apply {
            lifecycleOwner = this@VideoLearningFragment
            model = this@VideoLearningFragment.model
            viewAccess = this@VideoLearningFragment
        }

        return binding.root
    }


}
