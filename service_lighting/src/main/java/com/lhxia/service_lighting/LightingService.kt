package com.lhxia.service_lighting

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.lhxia.middle_core.app.BaseFragment

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
interface LightingService: IProvider {

    fun startMain(context: Context)
}