package com.lhxia.module_login.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.module_login.manager.clearLoginInfo
import com.lhxia.service_login.LoginService

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/login/service", name = "目标模块服务")
class LoginServiceImpl: LoginService {

    override fun init(context: Context?) {
    }

    override fun startLogin(context: Context) {
        ARouter.getInstance().build("/login/login").navigation(context)
    }

    override fun isLogin(context: Context): Boolean {
        return com.lhxia.module_login.manager.isLogin(context)
    }

    override fun getUserId(context: Context): String {
        return com.lhxia.module_login.manager.getUserId(context)
    }

    override fun logout(context: Context) {
        clearLoginInfo(context)
    }
}