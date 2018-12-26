package com.hx.cocovideo.presenter

import android.os.Bundle
import android.text.TextUtils
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.CategoryItem
import com.henry.cocovideo.bean.VideoDetail
import com.hx.cocovideo.contract.CategoryPageContentContract
import com.hx.cocovideo.contract.MainPageFragmentContract
import com.hx.cocovideo.model.CategoryPageModel
import com.hx.cocovideo.model.MainPageFragmentModel

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：
 */
class CategoryPagePresenter(override var view: CategoryPageContentContract.View) : CategoryPageContentContract.Presenter {
    private val model = CategoryPageModel(object : DataResponseListener {
        override fun onResult(dataType: String, result: Any) {
            if (TextUtils.equals(BaseModel.DATA_TYPE_CATEGORY_VIDEO, dataType)) {
                view.refreshPageContent(result as MutableList<VideoDetail>)
            }
        }

    })

    override fun requestVideoByCategoryName(categoryName: String) {
        model.requestVideoByCategoryName(categoryName)
    }

    override fun start(params: Bundle) {

    }
}