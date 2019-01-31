package com.hx.cocovideo.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.henry.cocovideo.bean.User
import com.hx.cocovideo.R
import com.hx.cocovideo.contract.LoginContract
import com.hx.cocovideo.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import java.time.LocalDate


class LoginActivity : AppCompatActivity(), LoginContract.View {


    override var presenter: LoginContract.Presenter
        get() = LoginPresenter(this)
        set(value) {}

    //测试账号   henry, 123456

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onRegisterClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun onLoginButtonClick(view: View) {
        val account = loginAccountEt.text.toString()
        val password = loginPasswordEt.text.toString()
        presenter.requestLogin(account, password)
    }

    override fun onLoginFailed(reason: String) {
        Log.d("HR", "reason: " + reason)
        Toast.makeText(this, reason, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(user: User) {
        Log.d("HR", "user: " + user.name)
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }
}
