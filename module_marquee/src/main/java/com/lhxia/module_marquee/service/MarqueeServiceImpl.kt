package com.lhxia.module_marquee.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.service_marquee.MarqueeService

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/marquee/service", name = "目标模块服务")
class MarqueeServiceImpl: MarqueeService {
    override fun startMain(context: Context) {
        ARouter.getInstance().build("/marquee/main").navigation(context)
    }

    override fun init(context: Context?) {
    }

}