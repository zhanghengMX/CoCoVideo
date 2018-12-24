package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView

/**
 * author：heng.zhang
 * date：2018/12/24
 * description：
 */
interface FragmentBaseContract {
    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter<View> {

    }
}