package com.hx.cocovideo.contract

import com.henry.cocovideo.base.BasePresenter
import com.henry.cocovideo.base.BaseView
import com.henry.cocovideo.bean.User

/**
 * author：heng.zhang
 * date：2019/2/1
 * description：
 */
interface RegisterContract {
    interface View : BaseView<Presenter> {
        fun sendSmsCodeSuccess()
        fun sendSmsCodeFailed()
        fun onVerifySmsCodeSuccess()
        fun onVerifySmsCodeFailed()
    }

    interface Presenter : BasePresenter<View> {
        fun sendSmsCode(telephoneNumber: String)
        fun verifySmsCode(telephoneNumber: String, smsCode: String, callBack: SmsCodeVerifyCallBack)
    }

    interface SmsCodeVerifyCallBack {
        fun verifySuccess()
        fun verifyFailed()
    }
}