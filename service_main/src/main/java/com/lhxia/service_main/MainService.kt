package com.lhxia.service_main

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
interface MainService: IProvider {

    /**
     * 回到主界面
     */
    fun startMain(context: Context)
}