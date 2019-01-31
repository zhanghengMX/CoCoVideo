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
import com.hx.cocovideo.model.LoginModel

/**
 * author：heng.zhang
 * date：2019/1/31
 * description：
 */
class LoginPresenter(override var view: LoginContract.View) : LoginContract.Presenter {

    private val model = LoginModel(object : DataResponseListener {
        override fun onResult(dataType: String, result: Any) {
            if (BaseModel.DATA_TYPE_LOGIN_SUCCESS.equals(dataType)) {
                view.onLoginSuccess(result as User)
            } else if (BaseModel.DATA_TYPE_LOGIN_FAILED.equals(dataType)) {
                view.onLoginFailed(result as String)
            }
        }

    })
    override fun requestLogin(account: String, password: String) {
        model.requestLogin(account, password)
    }
}