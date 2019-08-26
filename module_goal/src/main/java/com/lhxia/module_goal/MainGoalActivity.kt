package com.lhxia.module_goal

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseActivity
import kotlinx.android.synthetic.main.goal_fragment_goal_list.view.*
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

@Route(path = "/goal/main", name = "目标列表fragment")
class MainGoalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {

        }
    }
}
