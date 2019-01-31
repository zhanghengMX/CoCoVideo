package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView
import com.henry.cocovideo.bean.User

/**
 * author：heng.zhang
 * date：2019/1/31
 * description：
 */
interface LoginContract {
    interface View : BaseView<Presenter> {
        fun onLoginFailed(reason: String)
        fun onLoginSuccess(user: User)

    }

    interface Presenter : BasePresenter<View> {
        fun requestLogin(account: String, password: String)
    }
}