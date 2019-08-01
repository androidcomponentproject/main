package com.lhxia.module_goal.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.middle_core.app.BaseFragment
import com.lhxia.service_goal.GoalService

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/goal/service", name = "目标模块服务")
class GoalServiceImpl: GoalService {

    override fun getGoalListFragment(): BaseFragment {
        return (ARouter.getInstance().build("/goal/goalList").navigation() as BaseFragment?)!!
    }

    override fun init(context: Context?) {
    }

}