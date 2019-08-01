package com.lhxia.module_login.manager

import android.content.Context
import androidx.core.content.edit
import com.lhxia.middle_core.ktx.getSharePreference
import com.lhxia.module_login.LoginModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */

fun getLoginConfig(context: Context) = LoginModule.module.getSharePreference(context, "login_info")

fun saveLoginInfo(context: Context, userId: String){
    getLoginConfig(context).edit {
        putString("userId", userId)
    }
}

fun clearLoginInfo(context: Context){
    getLoginConfig(context).edit {
        clear()
    }
}

fun getUserId(context: Context) = getLoginConfig(context).getString("userId", "")

fun isLogin(context: Context) = !getLoginConfig(context).getString("userId", "").isNullOrEmpty()