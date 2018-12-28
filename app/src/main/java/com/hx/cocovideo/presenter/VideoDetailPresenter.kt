package com.hx.cocovideo.presenter

import com.henry.cocovideo.base.DataResponseListener
import com.hx.cocovideo.contract.VideoDetailContract
import com.hx.cocovideo.model.VideoDetailModel

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：
 */
class VideoDetailPresenter(override var view: VideoDetailContract.View) : VideoDetailContract.Presenter {
    override fun getVideoDetailData(videoId: String) {
        model.requestVideoDetail(videoId)
    }

    override fun getVideoUrls(videoId: String) {
        model.requestVideoUrl(videoId)
    }

    private val model = VideoDetailModel(object : DataResponseListener {
        override fun onResult(dataType: String, result: Any) {

        }

    })
}