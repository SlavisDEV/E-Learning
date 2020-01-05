package com.softroids.emptyproject.ui.learning.video

import com.google.android.exoplayer2.ui.PlayerView

interface VideoLearningFragmentViewAccess {

    fun addVideoView(videoView: PlayerView, position: Int)
    fun removeVideoView(videoView: PlayerView)
    fun showVideoLoader(position: Int)
    fun hideVideoLoader(position: Int)
    fun hidePlayVideoButton(position: Int)
    fun showPlayVideoButton(position: Int)
}