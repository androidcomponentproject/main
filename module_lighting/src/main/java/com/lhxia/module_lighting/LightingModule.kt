package com.lhxia.module_lighting

import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.IModule
import com.lhxia.middle_core.module.getModule
import com.lhxia.middle_core.module.register

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class LightingModule: IModule {

    companion object {
        lateinit var module: LightingModule
    }

    override fun moduleId(): String {
        return "lighting"
    }

    override fun onCreate(application: BaseApplication) {
        module = this
    }

    override fun onLoad(application: BaseApplication) {
    }
}