package com.hx.cocovideo.fragment

import android.app.Fragment
import android.content.Context
import com.hx.cocovideo.activity.VideoDetailActivity

abstract class DetailBaseFragment : Fragment() {
    lateinit var videoDetailActivity: VideoDetailActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        videoDetailActivity = context as VideoDetailActivity

    }

    abstract fun refreshFragmentData(data: Any)
}
