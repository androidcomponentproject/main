package com.lhxia.module_main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.app.BaseFragment
import com.lhxia.middle_core.ktx.async
import com.lhxia.middle_core.ktx.launch
import com.lhxia.middle_core.ktx.service
import com.lhxia.module_main.ui.AllToolFragment
import com.lhxia.service_goal.GoalService
import com.lhxia.service_login.LoginService
import kotlinx.android.synthetic.main.main_activity_main.*
import kotlinx.coroutines.*
import org.jetbrains.anko.*
import kotlin.system.measureTimeMillis

@Route(path = "/main/main", name = "主界面")
class MainActivity : BaseActivity() {

//    lateinit var logoutButton: Button
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {

//            logoutButton = button("退出登录")

            tabLayout = TabLayout(context)
            addView(tabLayout, -1, -2)

            viewPager2 = ViewPager2(context).apply {
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
            }
            addView(viewPager2, -1, -2)


        }

        viewPager2.adapter = FragmentListAdapter(this@MainActivity, arrayListOf(
            AllToolFragment.newInstance(),
            service<GoalService>().getGoalListFragment(),
            AllToolFragment.newInstance(),
            AllToolFragment.newInstance()))
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when(position){
                0 -> tab.text = "所有"
                else -> {
                    tab.text = "其他"
                }
            }

        }.attach()
//        logoutButton.setOnClickListener {
//            service<LoginService>().logout(it.context)
//            checkLogin()
//        }
    }

    override fun onResume() {
        super.onResume()
//        checkLogin()
    }

//    private fun checkLogin(){
////        val time = measureTimeMillis {
//            service<LoginService>().apply {
//                if (!isLogin(this@MainActivity)) {
////                    logoutButton.visibility = View.GONE
//                    startLogin(this@MainActivity)
//                } else {
////                    logoutButton.visibility = View.VISIBLE
//                }
//            }
////        }
////        toast("time2 $time")
//    }

}

class FragmentListAdapter(fragmentActivity: BaseActivity, private val fragmentList: List<Fragment?>) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]!!
    }

//    override fun getItem(position: Int): Fragment {
//        return fragmentList.value[position]
//    }



//
//    override fun createFragment(position: Int): Fragment {
//        return fragmentList.value[position]
//    }

    override fun getItemCount(): Int = fragmentList.size

}


