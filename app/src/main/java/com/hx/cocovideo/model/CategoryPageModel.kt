package com.hx.cocovideo.model

import android.util.Log
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.CategoryItem
import com.henry.cocovideo.bean.VideoDetail

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：栏目下的内容fragment的presenter
 */
class CategoryPageModel(override var responseListener: DataResponseListener) : BaseModel {

    fun requestVideoByCategoryName(categoryName: String) {
        val query = BmobQuery<VideoDetail>()
        query.addWhereContainsAll("genres", listOf(categoryName))
                .findObjects(object : FindListener<VideoDetail>() {
                    override fun done(p0: MutableList<VideoDetail>?, p1: BmobException?) {
                        if (p1 == null && p0 != null) {
                            responseListener.onResult(BaseModel.DATA_TYPE_CATEGORY_VIDEO, p0)
                        } else {
                            Log.e("CategoryPageModel", "request video by category name error")
                        }
                    }
                })
    }
}