package com.lhxia.timemanager

import android.content.Context
import androidx.multidex.MultiDex
import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.register
import com.lhxia.module_main.MainModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class TimeManagerApplication: BaseApplication() {

    override fun initModule() {
        register(MainModule(), this)
        super.initModule()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}