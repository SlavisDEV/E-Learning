package com.softroids.emptyproject.ui.learning.video

import android.content.Context
import android.graphics.Point
import android.net.Uri
import android.view.View
import android.view.WindowManager
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import javax.inject.Inject

class VideoLearningFragmentViewModel @Inject constructor() {

    private val urls = arrayListOf(
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
    )

    @Inject
    protected lateinit var viewAccess: VideoLearningFragmentViewAccess

    @Inject
    protected lateinit var context: Context

    private lateinit var videoView: PlayerView
    private var videoPlayer: SimpleExoPlayer? = null
    private var videoSurfaceDefaultHeight = 0
    private var screenDefaultHeight = 0
    private var isVideoViewAdded: Boolean = false

    private fun setupPlayer(position: Int) {
        releasePlayer(if (position == 1) 0 else 1)
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val point = Point()
        display.getSize(point)
        videoSurfaceDefaultHeight = point.x
        screenDefaultHeight = point.y

        videoView = PlayerView(this.context).apply {
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        }

        videoPlayer = ExoPlayerFactory.newSimpleInstance(context)
        videoView.apply {
            useController = true
            player = videoPlayer
        }
    }

    fun onVideoClicked(position: Int) {
        setupPlayer(position)
        playVideo(position)
        viewAccess.hidePlayVideoButton(position)
        viewAccess.showVideoLoader(position)
        videoPlayer?.addListener(object: Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                when (playbackState) {
                    Player.STATE_BUFFERING -> viewAccess.showVideoLoader(position)
                    Player.STATE_ENDED -> videoPlayer?.seekTo(0)
                    Player.STATE_READY -> {
                        viewAccess.hideVideoLoader(position)
                        if(!isVideoViewAdded) {
                            addVideoView(position)
                        }
                    }
                }
            }
        })
    }

    private fun playVideo(position: Int) {
        videoView.visibility = View.INVISIBLE

        videoView.player = videoPlayer

        val dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "RecyclerView Video")
        )
        val videoSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(urls[position]))
        videoPlayer?.prepare(videoSource)
        videoPlayer?.playWhenReady = true
    }

    private fun addVideoView(position: Int) {
        viewAccess.addVideoView(videoView, position)
        isVideoViewAdded = true
        videoView.apply {
            requestFocus()
            visibility = View.VISIBLE
            alpha = 1f
        }
    }

    fun releasePlayer(position: Int = -1) {
        if (videoPlayer != null) {
            viewAccess.removeVideoView(videoView)
            isVideoViewAdded = false
            videoPlayer!!.release()
            videoPlayer = null
            if (position >= 0) {
                viewAccess.showPlayVideoButton(position)
            }
        }
    }

}