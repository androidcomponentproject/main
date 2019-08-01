package com.lhxia.module_main.ui


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lhxia.middle_core.app.BaseFragment

import com.lhxia.module_main.R
import com.lhxia.module_main.tool.beans.Tool
import com.lhxia.module_main.tool.beans.startToolMainUI
import com.lhxia.module_main.tool.repos.ToolRepo
import kotlinx.android.synthetic.main.main_fragment_all_tool.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * A simple [Fragment] subclass.
 * Use the [AllToolFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AllToolFragment : BaseFragment() {

    private val toolRepo: ToolRepo = ToolRepo()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment_all_tool, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        toolRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        toolRecyclerView.adapter = ToolListAdapter(context!!, toolRepo.getAllTools())
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            AllToolFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}


class ToolListAdapter(context: Context, var toolList : List<Tool>): RecyclerView.Adapter<ListItemUI.VH>() {
    private val ankoContext = AnkoContext.createReusable(context, this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemUI.VH {

        return ListItemUI().createView(ankoContext).tag as ListItemUI.VH
    }

    override fun getItemCount(): Int = toolList.size

    override fun onBindViewHolder(holder: ListItemUI.VH, position: Int) {
        val item = toolList[position]
        holder.paramHolder.button.text = item.name
        holder.paramHolder.button.onClick {
            item.startToolMainUI(it!!.context)
        }
    }

}

class ListItemUI : AnkoComponent<RecyclerView.Adapter<ListItemUI.VH>> {
    override fun createView(ui: AnkoContext<RecyclerView.Adapter<VH>>): View {

        val paramHolder = VH.ParamHolder()
        val view = ui.apply {
            relativeLayout {
                paramHolder.button = button {

                }.lparams(-1, -2)
            }.layoutParams = RecyclerView.LayoutParams(-1, -2)
        }.view
        view.tag = VH(paramHolder, view)
        return view
    }


    class VH(val paramHolder: ParamHolder, itemView: View) : RecyclerView.ViewHolder(itemView){


        class ParamHolder {
            lateinit var button: Button
        }
    }


}
