package com.hx.cocovideo.presenter

import android.text.TextUtils
import android.util.Log
import android.webkit.WebView
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.User
import com.hx.cocovideo.contract.LoginContract
import com.hx.cocovideo.contract.RegisterContract
import com.hx.cocovideo.model.LoginModel
import com.hx.cocovideo.model.RegisterModel

/**
 * author：heng.zhang
 * date：2019/1/31
 * description：
 */
class RegisterPresenter(override var view: RegisterContract.View) : RegisterContract.Presenter {
    override fun sendSmsCode(telephoneNumber: String) {

    }

    override fun verifySmsCode(telephoneNumber: String, smsCode: String, callback: RegisterContract.SmsCodeVerifyCallBack) {

    }

    private val model = RegisterModel(object : DataResponseListener {
        override fun onResult(dataType: String, result: Any) {
            if (BaseModel.DATA_TYPE_LOGIN_SUCCESS.equals(dataType)) {
            } else if (BaseModel.DATA_TYPE_LOGIN_FAILED.equals(dataType)) {
            }
        }

    })
}