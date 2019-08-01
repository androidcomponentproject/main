package com.lhxia.middle_core.ktx

import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.app.BaseFragment
import com.lhxia.middle_core.presenter.BasePresenter
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */

fun BaseActivity.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return coroutineSupport.launch(context, start, block)
}

fun <T> BaseActivity.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    return coroutineSupport.async(context, start, block)
}

fun BaseFragment.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return coroutineSupport.launch(context, start, block)
}

fun <T> BaseFragment.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    return coroutineSupport.async(context, start, block)
}

fun BasePresenter.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return coroutineSupport.launch(context, start, block)
}

fun <T> BasePresenter.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    return coroutineSupport.async(context, start, block)
}

fun BaseActivity.coroutineContext(): CoroutineContext {
    return coroutineSupport.coroutineContext
}
fun BaseFragment.coroutineContext(): CoroutineContext {
    return coroutineSupport.coroutineContext
}
fun BasePresenter.coroutineContext(): CoroutineContext {
    return coroutineSupport.coroutineContext
}