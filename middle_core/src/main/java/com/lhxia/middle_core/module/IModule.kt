package com.lhxia.middle_core.module

import com.lhxia.middle_core.app.BaseApplication

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
interface IModule {

    fun moduleId(): String

    fun onCreate(application: BaseApplication)

    fun onLoad(application: BaseApplication)
}