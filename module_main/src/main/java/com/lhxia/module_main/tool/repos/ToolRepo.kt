package com.lhxia.module_main.tool.repos

import com.lhxia.module_main.tool.beans.Tool

/**
 * @Author : xialonghua
 * @Date : Create in 2019-08-01
 * @Description : a new file
 */
class ToolRepo {

    fun getAllTools(): List<Tool>{

        return arrayListOf(
            Tool("marquee", "常用工具", "屏幕跑马灯", "marquee"),
            Tool("lighting", "常用工具", "手电筒", "lighting"),
            Tool("goal", "常用工具", "时间管理", "gaol")
        )
    }
}