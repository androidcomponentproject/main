package com.lhxia.module_goal.repo

import com.lhxia.module_goal.bean.Goal

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
class GoalRepo {

    fun loadGoalList(): List<Goal>{
        return arrayListOf<Goal>().apply{
            repeat(10){
                add(Goal("$it", "目标$it", System.currentTimeMillis()))
            }
        }
    }
}