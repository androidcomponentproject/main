package com.lhxia.module_main.tool.beans

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.lhxia.middle_core.ktx.service
import com.lhxia.service_goal.GoalService
import com.lhxia.service_lighting.LightingService
import com.lhxia.service_marquee.MarqueeService

/**
 *
 * 工具模型
 * @Author : xialonghua
 * @Date : Create in 2019-08-01
 * @Description : a new file
 */
class Tool(
    //唯一ID
    var id: String,
    //类型
    var type: String,
    //名字
    var name: String,
    //所属module
    var module: String)


fun Tool.startToolMainUI(context: Context){
    return when(module){
        "marquee" -> service<MarqueeService>().startMain(context)
        "lighting" -> service<LightingService>().startMain(context)
        "goal" -> service<GoalService>().startMain(context)
        else -> {}
    }
}