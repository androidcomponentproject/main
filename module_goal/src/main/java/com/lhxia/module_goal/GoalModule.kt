package com.lhxia.module_goal

import com.lhxia.middle_core.app.BaseApplication
import com.lhxia.middle_core.module.IModule

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
class GoalModule: IModule {
    override fun moduleId(): String {
        return "goal"
    }

    override fun onCreate(application: BaseApplication) {
    }

    override fun onLoad(application: BaseApplication) {
    }
}