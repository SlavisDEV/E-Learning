package com.softroids.emptyproject.ui.learning.photo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.FragmentPhotoLearningBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.learning.photo.PhotoLearningFragmentModule
import kotlinx.android.synthetic.main.fragment_photo_learning.*
import javax.inject.Inject

class PhotoLearningFragment : Fragment(), PhotoLearningFragmentViewAccess {

    private lateinit var binding: FragmentPhotoLearningBinding

    @Inject
    protected lateinit var model: PhotoLearningFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        App.get(activity!!)
            .getAppComponent()
            .plus(PhotoLearningFragmentModule(this))
            .inject(this)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_learning, null, false)
        binding.apply {
            lifecycleOwner = this@PhotoLearningFragment
            model = this@PhotoLearningFragment.model
            viewAccess = this@PhotoLearningFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImages()
    }

    private fun setupImages() {
        Glide.with(this)
            .load("https://s.redefine.pl/file/o2/redefine/cp/6n/6n2hbbjhytv8rnkh94its6aaq2o5bbj3.jpg")
            .into(imageView_mainImage)

        Glide.with(this)
            .load("https://fcinter.pl/rails/active_storage/blobs/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBajRoIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--8fd3089b1ac57be876f6da6f772d6c304858d205/san-siro.jpg")
            .into(imageView_additionalImage)

        Glide.with(this)
            .load("https://www.isportconnect.com/wp-content/uploads/2018/07/San-Siro-2100x1200.jpg")
            .into(imageView_additionalImage_2)
    }

}
