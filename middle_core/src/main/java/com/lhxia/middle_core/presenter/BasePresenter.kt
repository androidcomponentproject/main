package com.lhxia.middle_core.presenter

import androidx.fragment.app.Fragment
import com.lhxia.lib_coroutine.CoroutineSupport
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class BasePresenter(parent: Job? = null) {

    internal val coroutineSupport: CoroutineSupport = CoroutineSupport(parent)


    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return coroutineSupport.launch(context, start, block)
    }

    fun async(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return coroutineSupport.async(context, start, block)
    }

    fun onDestroy() {
        coroutineSupport.destroy()
    }
}