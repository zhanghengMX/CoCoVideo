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
 * description：
 */
class MainPageFragmentModel(override var responseListener: DataResponseListener) : BaseModel {
    fun requestCategoryData(videoType: String) {
        val query = BmobQuery<CategoryItem>()
        query.setLimit(50)
        query.findObjects(object : FindListener<CategoryItem>() {
            override fun done(p0: MutableList<CategoryItem>?, p1: BmobException?) {
                if (p1 == null && p0 != null) {
                    responseListener.onResult(BaseModel.DATA_TYPE_CATEGORY, p0)
                } else {
                    Log.e("MainPageFragmentModel", "query category data error")
                }
            }

        })
    }

    fun requestVideoByCategoryName(categoryName: String) {
        val query = BmobQuery<VideoDetail>()
        query.addWhereContainsAll("genres", listOf(categoryName))
                .findObjects(object : FindListener<VideoDetail>() {
                    override fun done(p0: MutableList<VideoDetail>?, p1: BmobException?) {
                        //TODO 使用数据构建UI，传递给RecylerView
                    }

                })
    }
}