package com.lhxia.module_lighting.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.service_lighting.LightingService

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/lighting/service", name = "目标模块服务")
class LightingServiceImpl: LightingService {
    override fun startMain(context: Context) {
        ARouter.getInstance().build("/lighting/main").navigation(context)
    }

    override fun init(context: Context?) {
    }

}