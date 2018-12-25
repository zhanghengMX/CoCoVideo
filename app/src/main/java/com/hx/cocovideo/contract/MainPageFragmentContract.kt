package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView
import com.henry.cocovideo.bean.CategoryItem

/**
 * author：heng.zhang
 * date：2018/12/24
 * description：
 */
interface MainPageFragmentContract {
    interface View : BaseView<Presenter> {
        fun refreshCategoryData(data: MutableList<CategoryItem>)
    }

    interface Presenter : BasePresenter<View> {
        fun requestCategoryData(videoType : String)
    }
}