package com.lhxia.module_goal

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.customview.widget.ViewDragHelper
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchUIUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lhxia.middle_core.app.BaseFragment
import com.lhxia.module_goal.bean.Goal
import com.lhxia.module_goal.repo.GoalRepo
import kotlinx.android.synthetic.main.goal_fragment_goal_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onDrag
import org.jetbrains.anko.sdk27.coroutines.onLongClick
import org.jetbrains.anko.sdk27.coroutines.onTouch
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.dip
import org.jetbrains.anko.support.v4.toast

/**
 * @Author : xialonghua
 * @Date : Create in 2019-07-01
 * @Description : a new file
 */
@Route(path = "/goal/goalList", name = "目标列表fragment")
class GoalListFragment(parent: Job? = null) : BaseFragment(parent) {

    lateinit var recyclerView: RecyclerView
    lateinit var currentGoalView: View
    lateinit var currentGoalTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return UI {

            relativeLayout() {
                verticalLayout {
                    toolbar {
                        backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        title = "时间管理"
                        setTitleTextColor(Color.WHITE)
                    }

                    textView("当前执行")
                    currentGoalView = relativeLayout {

                        currentGoalTextView = textView("请将任务拖到这里，开始执行"){
                            backgroundResource = R.drawable.goal_bg_dot
                            gravity = Gravity.CENTER
                        }.lparams(-1, -1){
                            margin = dip(10)
                            addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
                        }


                    }.lparams(-1, dip(80))

                    textView("未完成")

                    recyclerView = recyclerView {  }

                }.lparams(-1, -1)
                floatingActionButton {
                    this.show()
                }.lparams{
                    addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
                    addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
                    bottomMargin = dip(20)
                    marginEnd = dip(20)
                }
            }
        }.view


//
//        return inflater.inflate(R.layout.goal_fragment_goal_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = GoalListAdapter(context!!, GoalRepo().loadGoalList(), coroutine())
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)

                outRect.left = dip(10)
                outRect.right = dip(10)
                outRect.top = dip(5)
            }
        })
        currentGoalView.setOnDragListener { v, event ->
            when(event.action){
                DragEvent.ACTION_DRAG_ENTERED -> {
                    currentGoalTextView.text = "松开，开始执行"
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    context?.toast("开始执行 $event")
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    currentGoalTextView.text = "请将任务拖到这里，开始执行"
                }
            }
            return@setOnDragListener true
        }
    }
}



class GoalListAdapter(context: Context, var goalList : List<Goal>, var conroutineSupport: CoroutineScope): RecyclerView.Adapter<ListItemUI.VH>() {
    private val ankoContext = AnkoContext.createReusable(context, this)

    private var touchJob: Job? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemUI.VH {

        return ListItemUI().createView(ankoContext).tag as ListItemUI.VH
    }

    override fun getItemCount(): Int = goalList.size

    override fun onBindViewHolder(holder: ListItemUI.VH, position: Int) {
        holder.paramHolder.titleView.text = goalList[position].name

        holder.itemView.onLongClick(returnValue = true) {
            val builder = object : View.DragShadowBuilder(holder.itemView) {
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                holder.itemView.startDragAndDrop(null, builder, null, 0)
            }else {
                holder.itemView.startDrag(null, builder, null, 0)
            }

        }

    }

}

class ListItemUI : AnkoComponent<RecyclerView.Adapter<ListItemUI.VH>> {

    override fun createView(ui: AnkoContext<RecyclerView.Adapter<VH>>): View {

        val paramHolder = VH.ParamHolder()
        val view = ui.apply {
            relativeLayout {
                cardView {
                    radius = 10f
                    cardElevation = 5f
                    useCompatPadding = true
                    preventCornerOverlap = false

                    verticalLayout {
                        padding = dip(10)
                        paramHolder.titleView = textView("xxxxx"){
                            textColor = Color.BLACK
                        }

                        textView("耗时:"){
                            textColor = Color.BLACK
                        }

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

