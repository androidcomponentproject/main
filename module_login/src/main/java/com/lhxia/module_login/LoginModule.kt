package com.lhxia.module_login

import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.IModule
import com.lhxia.middle_core.module.getModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
class LoginModule: IModule {

    companion object {
        lateinit var module: LoginModule
    }

    override fun moduleId(): String {
        return "login"
    }

    override fun onCreate(application: BaseApplication) {
        module = this
    }

    override fun onLoad(application: BaseApplication) {

    }
}