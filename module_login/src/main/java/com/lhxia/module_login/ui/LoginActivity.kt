package com.lhxia.module_login.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.ktx.coroutineContext
import com.lhxia.middle_core.ktx.getSharePreference
import com.lhxia.middle_core.ktx.launch
import com.lhxia.module_login.LoginModule
import com.lhxia.module_login.manager.saveLoginInfo
import kotlinx.coroutines.delay
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
@Route(path = "/login/login", name = "登录界面")
class LoginActivity: BaseActivity() {

    private lateinit var mobileView: EditText
    private lateinit var mobileCodeView: EditText
    private lateinit var getCodeView: Button
    private lateinit var loginView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dsl()
    }

    private suspend fun getCodeSuspend(){
        if (!getCodeView.isEnabled){
            return
        }
        getCodeView.isEnabled = false
        repeat(60){
            getCodeView.text = "请稍候(${60 - it})"
            delay(1000)
        }
        getCodeView.isEnabled = true
    }

    private suspend fun loginSuspend(){
        loginView.isEnabled = false
        mobileView.isEnabled = false
        mobileCodeView.isEnabled = false
        getCodeView.isEnabled = false
        loginView.text = "正在登录,请稍候"
        delay(2000)

        saveLoginInfo(this, "1212")

        loginView.text = "登录成功"
        loginView.isEnabled = true
        mobileView.isEnabled = true
        mobileCodeView.isEnabled = true
        getCodeView.isEnabled = true
        finish()
    }

    @SuppressLint("SetTextI18n")
    private fun dsl(){
        verticalLayout {

            mobileView = editText {
                hint = "请输入手机号"
            }

            mobileCodeView = editText {
                hint = "请输入验证码"
            }

            getCodeView = button("获取验证码");
            getCodeView.setOnClickListener {
                launch {
                    getCodeSuspend()
                }
            }

            loginView = button("登录")
            loginView.setOnClickListener {
                launch {
                    loginSuspend()
                }

            }
        }
    }
}