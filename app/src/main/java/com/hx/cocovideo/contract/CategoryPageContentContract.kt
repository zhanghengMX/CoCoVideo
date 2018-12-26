package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView
import com.henry.cocovideo.bean.CategoryItem
import com.henry.cocovideo.bean.VideoDetail

/**
 * author：heng.zhang
 * date：2018/12/24
 * description：
 */
interface CategoryPageContentContract {
    interface View : BaseView<Presenter> {
        fun refreshPageContent(data: MutableList<VideoDetail>)
    }

    interface Presenter : BasePresenter<View> {
        fun requestVideoByCategoryName(categoryName : String)
    }
}