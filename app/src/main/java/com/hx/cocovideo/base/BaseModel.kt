package com.henry.cocovideo.base

/**
 * author：heng.zhang
 * date：2018/11/7
 * description：
 */
interface BaseModel {
    var responseListener : DataResponseListener
    companion object{
        val DATA_TYPE_SEARCH_RESULT = "@data-type-searche_result"
        val DATA_TYPE_CATEGORY = "@data-type-category"
        val DATA_TYPE_CATEGORY_VIDEO = "@data-type-category-video"
        val DATA_TYPE_VIDEO_DETAIL = "@data-type-video-detail"
        val DATA_TYPE_VIDEO_URL = "@data-type-video-url"
        val DATA_TYPE_LOGIN_SUCCESS = "@data-type-login-success"
        val DATA_TYPE_LOGIN_FAILED = "@data-type-login-failed"
    }
}