package com.lhxia.timemanager

import android.content.Context
import androidx.multidex.MultiDex
import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.register
import com.lhxia.module_goal.GoalModule
import com.lhxia.module_login.LoginModule
import com.lhxia.module_main.MainModule
import com.lhxia.module_marquee.MarqueeModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class TimeManagerApplication: BaseApplication() {

    override fun initModule() {
        register(LoginModule(), this)
        register(MainModule(), this)
        register(MarqueeModule(), this)
        register(GoalModule(), this)
        super.initModule()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}