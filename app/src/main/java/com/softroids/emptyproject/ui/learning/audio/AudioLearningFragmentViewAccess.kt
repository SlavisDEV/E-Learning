package com.softroids.emptyproject.ui.learning.audio

import com.google.android.exoplayer2.ui.PlayerView

interface AudioLearningFragmentViewAccess {

    fun addVideoView(videoView: PlayerView, position: Int)
    fun removeVideoView(videoView: PlayerView)
    fun showVideoLoader(position: Int)
    fun hideVideoLoader(position: Int)
    fun hidePlayVideoButton(position: Int)
    fun showPlayVideoButton(position: Int)
}