package com.lhxia.module_goal.dsl

import android.content.Context
import android.view.View
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.module_goal.GoalListAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.*

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-02
 * @Description : a new file
 */
class A{
    suspend fun aaa(aaa: String): String{
        bbb(aaa)
        return "aaa"
    }

    suspend fun bbb(bbb: String): String{
        return "bbb"
    }

}

fun cccc()  {
    GlobalScope.launch {
        A().aaa("asasas")
    }
}