package com.lhxia.middle_core.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
open class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initBaseComponent()
        initModule()
        onCreateFinish()
    }

    open fun initBaseComponent(){
//        ARouter.openLog()     // 打印日志
//        ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this) // 尽可能早，推荐在Application中初始化

    }

    open fun initModule(){
        com.lhxia.middle_core.module.initModule(this)
    }

    open fun onCreateFinish(){
    }
}