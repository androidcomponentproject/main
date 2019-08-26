package com.lhxia.module_goal

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseActivity
import org.jetbrains.anko.frameLayout

@Route(path = "/goal/main", name = "目标列表fragment")
class MainGoalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val container = frameLayout {
            id = View.generateViewId()
        }

        supportFragmentManager.beginTransaction().replace(container.id, GoalListFragment()).commit()
    }
}
