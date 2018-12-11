package com.hx.cocovideo.player

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hx.cocovideo.R
import kotlinx.android.synthetic.main.activity_co_co_player.*
import com.dueeeke.videoplayer.player.PlayerConfig
import com.dueeeke.videocontroller.StandardVideoController


class CoCoPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_co_co_player)
        initPlayer()
        val videoName = intent.getStringExtra("video_name")
        val url = intent.getStringExtra("url")
        doPlay(videoName, url)
    }

    private fun initPlayer() {
        val controller = StandardVideoController(this)
        ijkPlayerView.setVideoController(controller) //设置控制器，如需定制可继承BaseVideoController

//        //高级设置（可选，须在start()之前调用方可生效）
        val playerConfig = PlayerConfig.Builder()
//                .enableCache() //启用边播边缓存功能
                .autoRotate() //启用重力感应自动进入/退出全屏功能
//                .enableMediaCodec()//启动硬解码，启用后可能导致视频黑屏，音画不同步
//                .usingSurfaceView() //启用SurfaceView显示视频，不调用默认使用TextureView
                .savingProgress() //保存播放进度
//                .disableAudioFocus() //关闭AudioFocusChange监听
//                .setLooping() //循环播放当前正在播放的视频
                .build()
        ijkPlayerView.setPlayerConfig(playerConfig)
    }

    private fun doPlay(videoName: String, url: String) {
        ijkPlayerView.setUrl(url) //设置视频地址
        ijkPlayerView.setTitle(videoName) //设置视频标题
        ijkPlayerView.start() //开始播放，不调用则不自动播放
    }

    override fun onPause() {
        super.onPause()
        ijkPlayerView.pause()
    }

    override fun onResume() {
        super.onResume()
        ijkPlayerView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        ijkPlayerView.release()
    }


    override fun onBackPressed() {
        if (!ijkPlayerView.onBackPressed()) {
            super.onBackPressed()
        }
    }
}
