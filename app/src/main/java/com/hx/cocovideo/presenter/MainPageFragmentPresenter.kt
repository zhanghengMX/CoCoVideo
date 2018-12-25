package com.hx.cocovideo.presenter

import android.os.Bundle
import android.text.TextUtils
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.CategoryItem
import com.hx.cocovideo.contract.MainPageFragmentContract
import com.hx.cocovideo.model.MainPageFragmentModel

/**
 * author：heng.zhang
 * date：2018/12/25
 * description：
 */
class MainPageFragmentPresenter(override var view: MainPageFragmentContract.View) : MainPageFragmentContract.Presenter {
    private val model = MainPageFragmentModel(object : DataResponseListener {
        override fun onResult(dataType: String, result: Any) {
            if (TextUtils.equals(BaseModel.DATA_TYPE_CATEGORY, dataType)) {
                view.refreshCategoryData(result as MutableList<CategoryItem>)
            }
        }

    })
    override fun requestCategoryData(videoType: String) {
        model.requestCategoryData(videoType)
    }

    override fun requestVideoByCategoryName(categoryName: String) {
        model.requestVideoByCategoryName(categoryName)
    }

    override fun start(params: Bundle) {

    }
}