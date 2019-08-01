package com.lhxia.service_login

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.lhxia.middle_core.app.BaseFragment

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
interface LoginService: IProvider {

    fun startLogin(context: Context)

    fun logout(context: Context)

    fun isLogin(context: Context): Boolean

    fun getUserId(context: Context): String
}