package com.henry.cocovideo.bean

import cn.bmob.v3.BmobObject

data class VideoUrl (val doubanId: String,
                     val name: String,
                     val index: Int,
                     val urls: MutableList<String>) : BmobObject() {
    companion object {
        val VIDEO_URL_TYPE_M3U8 = "0"
        val VIDEO_URL_TYPE_WEB = "1"
    }
}