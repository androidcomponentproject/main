package com.lhxia.module_goal

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseFragment
import com.lhxia.module_goal.bean.Goal
import com.lhxia.module_goal.repo.GoalRepo
import kotlinx.android.synthetic.main.goal_fragment_goal_list.*
import kotlinx.coroutines.Job
import org.jetbrains.anko.*

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/goal/goalList", name = "目标列表fragment")
class GoalListFragment(parent: Job? = null) : BaseFragment(parent) {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.goal_fragment_goal_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = GoalListAdapter(context!!, GoalRepo().loadGoalList())

    }
}



class GoalListAdapter(context: Context, var goalList : List<Goal>): RecyclerView.Adapter<ListItemUI.VH>() {
    private val ankoContext = AnkoContext.createReusable(context, this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemUI.VH {

        return ListItemUI().createView(ankoContext).tag as ListItemUI.VH
    }

    override fun getItemCount(): Int = goalList.size

    override fun onBindViewHolder(holder: ListItemUI.VH, position: Int) {
        holder.paramHolder.titleView.text = goalList[position].name
    }

}

class ListItemUI : AnkoComponent<RecyclerView.Adapter<ListItemUI.VH>> {
    override fun createView(ui: AnkoContext<RecyclerView.Adapter<VH>>): View {

        val paramHolder = VH.ParamHolder()
        val view = ui.apply {
            relativeLayout {
                relativeLayout{
                    paramHolder.backgroundView = imageView(R.drawable.abc_action_bar_item_background_material)
                }.lparams(-1, -2)
                verticalLayout {
                    paramHolder.titleView = textView("xxxxx"){
                        textColor = Color.BLACK
                    }.lparams(-1, -2)
                }.lparams(-1, -2)
            }
        }.view
        view.tag = VH(paramHolder, view)
        return view
    }


    class VH(val paramHolder: ParamHolder, itemView: View) : RecyclerView.ViewHolder(itemView){


        class ParamHolder {
            lateinit var backgroundView: ImageView
            lateinit var titleView: TextView
        }
    }


}

