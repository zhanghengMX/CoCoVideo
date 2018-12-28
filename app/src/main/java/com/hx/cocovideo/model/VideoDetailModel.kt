package com.hx.cocovideo.model

import android.util.Log
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.CategoryItem

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：
 */
class VideoDetailModel(override var responseListener: DataResponseListener) : BaseModel {
    fun requestVideoDetail(videoId: String) {
    }

    fun requestVideoUrl(videoId: String) {

    }
}