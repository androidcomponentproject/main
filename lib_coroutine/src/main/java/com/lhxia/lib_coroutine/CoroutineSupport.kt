package com.lhxia.lib_coroutine

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @Author : xialonghua
 * @Date : Create in 2019/3/28
 * @Description : 协程支持类，使用组合的方式比继承的方式灵活点，就是使用协程的时候要多个调用
 */
class CoroutineSupport(parent: Job? = null): CoroutineScope {

    private val job: Job = if (parent == null){
        SupervisorJob()
    }else {
        SupervisorJob(parent)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    /**
     * 取消协程上下文的job，
     * 取消后不要再使用了，
     * 如果再使用所有任务会不执行,
     * 一般在onDestroy里做
     */
    fun destroy(){
        job.cancel()
    }

    /**
     * 取消所有的子任务
     */
    fun cancelChildren(){
        job.cancelChildren()
    }

    fun isDestroy(): Boolean{
        return job.isCancelled
    }
}