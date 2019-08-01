package com.lhxia.middle_core.app

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.lhxia.lib_coroutine.CoroutineSupport
import com.lhxia.middle_core.presenter.BasePresenter
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
open class BaseActivity: AppCompatActivity() {

    internal val coroutineSupport: CoroutineSupport = CoroutineSupport()

    val handler = lazy { Handler() }
//    private val presenter: BasePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSupport.destroy()
    }

    fun getHandler(): Handler{
        return handler.value
    }
}