package com.hx.cocovideo.model

import android.text.TextUtils
import android.util.Log
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.henry.cocovideo.base.BaseModel
import com.henry.cocovideo.base.DataResponseListener
import com.henry.cocovideo.bean.User

/**
 * author：heng.zhang
 * date：2019/1/31
 * description：
 */
class LoginModel(override var responseListener: DataResponseListener) : BaseModel {

    fun requestLogin(account: String, password: String) {
        Log.d("HR", "account :" + account + "password:  "+ password)
        var userNameQuery = BmobQuery<User>()
        userNameQuery.addWhereEqualTo("name", account)
        val telephoneQuery = BmobQuery<User>()
        telephoneQuery.addWhereEqualTo("telephone", account)
        val queries = arrayListOf(userNameQuery, telephoneQuery)

        var query = BmobQuery<User>()
        query.or(queries)
        query.findObjects(object : FindListener<User>() {
            override fun done(p0: MutableList<User>?, p1: BmobException?) {
                if (p1 != null) {
                    responseListener.onResult(BaseModel.DATA_TYPE_LOGIN_FAILED, p1.message!!)
                    return
                }
                if (p0 == null || p0.size <= 0) {
                    responseListener.onResult(BaseModel.DATA_TYPE_LOGIN_FAILED,"账号不存在")
                    return
                }
                val user = p0[0]
                if (!TextUtils.equals(password, user.password)) {
                    responseListener.onResult(BaseModel.DATA_TYPE_LOGIN_FAILED,"密码错误")
                }
                responseListener.onResult(BaseModel.DATA_TYPE_LOGIN_SUCCESS, user)
            }
        })
    }
}