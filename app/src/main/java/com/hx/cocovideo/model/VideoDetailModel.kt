package com.hx.cocovideo.model

import android.util.Log
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.CategoryItem
import com.henry.cocovideo.bean.VideoUrl

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：
 */
class VideoDetailModel(override var responseListener: DataResponseListener) : BaseModel {
    fun requestVideoDetail(videoId: String) {
    }

    fun requestVideoUrl(videoId: String) {
        val query = BmobQuery<VideoUrl>()
        query.addWhereEqualTo("doubanId", videoId)
                .order("index")
                .findObjects(object : FindListener<VideoUrl>() {
                    override fun done(p0: MutableList<VideoUrl>?, p1: BmobException?) {
                        if(p1 == null && p0 != null) {
                            responseListener.onResult(BaseModel.DATA_TYPE_VIDEO_URL, p0)
                        }
                    }
                })
    }
}