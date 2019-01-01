package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView
import com.henry.cocovideo.bean.CategoryItem
import com.henry.cocovideo.bean.VideoDetail
import com.henry.cocovideo.bean.VideoUrl

/**
 * author：heng.zhang
 * date：2018/12/24
 * description：
 */
interface VideoDetailContract {
    interface View : BaseView<Presenter> {
        fun onVideoDetailLoaded(videoData: VideoDetail)
        fun onVideoUrlsLoaded(urls: MutableList<VideoUrl>)
    }

    interface Presenter : BasePresenter<View> {
        fun requestVideoDetailData(videoId: String)
        fun requestVideoUrls(videoId: String)
        fun getLocalVideoUrls(): MutableList<VideoUrl>
    }
}