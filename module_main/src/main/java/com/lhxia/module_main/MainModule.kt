package com.lhxia.module_main

import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.IModule
import com.lhxia.middle_core.module.getModule
import com.lhxia.middle_core.module.register
import com.lhxia.module_goal.GoalModule
import com.lhxia.module_login.LoginModule
import com.lhxia.module_marquee.MarqueeModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class MainModule: IModule {

    companion object {
        lateinit var module: MainModule
    }

    override fun moduleId(): String {
        return "main"
    }

    override fun onCreate(application: BaseApplication) {
        module = this
        register(LoginModule(), application)

        register(MarqueeModule(), application)
        register(GoalModule(), application)
    }

    override fun onLoad(application: BaseApplication) {
    }
}