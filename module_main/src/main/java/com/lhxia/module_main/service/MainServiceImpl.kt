package com.lhxia.module_main.service

import android.content.Context
import android.content.Intent
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.service_main.MainService

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
@Route(path = "/main/service", name = "主界面service")
class MainServiceImpl: MainService {
    override fun startMain(context: Context) {
        ARouter.getInstance().build("/main/main").navigation(context)
    }

    override fun init(context: Context?) {
    }
}