package com.hx.cocovideo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.hx.cocovideo.R
import com.hx.cocovideo.contract.RegisterContract
import com.hx.cocovideo.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    override var presenter: RegisterContract.Presenter
        get() = RegisterPresenter(this)
        set(value) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onRegisterButtonClick(view: View) {
        val telephone = registerTelephoneNumEt.text.toString()
        val smsCode = registerSmsCodeEt.text.toString()
        val password = registerPasswordEt.text.toString()
        val verifyPassword = registerPasswordVerifyEt.text.toString()
        if (!TextUtils.equals(password, verifyPassword)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_LONG).show()
            return
        }
        presenter.verifySmsCode(telephone, smsCode, object : RegisterContract.SmsCodeVerifyCallBack{
            override fun verifySuccess() {
                //TODO 添加用户到Bmob
            }

            override fun verifyFailed() {
                //TODO 提示错误
            }

        })
    }

    fun onGetSmsCodeClick(view: View) {
        val telephone = registerTelephoneNumEt.text.toString()
        presenter.sendSmsCode(telephone)
    }

    override fun sendSmsCodeSuccess() {
        //TODO 改变发送验证码按钮的文字显示
    }

    override fun sendSmsCodeFailed() {
        //TODO  待定
    }

    override fun onVerifySmsCodeSuccess() {

    }

    override fun onVerifySmsCodeFailed() {
    }
}
