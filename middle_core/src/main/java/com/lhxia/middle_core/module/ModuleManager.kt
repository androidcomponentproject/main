package com.lhxia.middle_core.module

import com.lhxia.middle_core.app.BaseApplication

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */

private val modules = HashMap<String, IModule>()

fun register(module: IModule, application: BaseApplication){
    if(modules.containsKey(module.moduleId())){
        return
    }
    modules[module.moduleId()] = module
    module.onCreate(application)
}

fun getModule(moduleId: String): IModule{
    return modules[moduleId]!!
}

internal fun initModule(application: BaseApplication){
    modules.values.forEach {
        it.onLoad(application)
    }
}