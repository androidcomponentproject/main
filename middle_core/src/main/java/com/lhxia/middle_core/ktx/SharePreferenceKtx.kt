package com.lhxia.middle_core.ktx

import android.content.Context
import android.content.SharedPreferences
import com.lhxia.middle_core.module.IModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
/**
 * 每个module可以获取属于自己的SP，sp格式为 moduleId_name
 */
fun IModule.getSharePreference(context: Context, name: String, mode: Int = Context.MODE_PRIVATE): SharedPreferences{
    return context.getSharedPreferences("${this.moduleId()}_$name", mode)
}
