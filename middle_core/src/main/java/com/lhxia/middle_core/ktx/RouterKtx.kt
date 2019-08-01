package com.lhxia.middle_core.ktx

import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
inline fun<reified T> service(): T = ARouter.getInstance().navigation(T::class.java)
