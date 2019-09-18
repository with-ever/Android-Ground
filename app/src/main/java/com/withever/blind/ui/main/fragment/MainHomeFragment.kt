package com.withever.blind.ui.main.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_home.*

class MainHomeFragment : BaseFragment() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId() = R.layout.fragment_main_home
    override fun createView(viewGroup: ViewGroup?) {
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun onResume() {
        super.onResume()
        initLayout()
        initData()
    }

    override fun initLayout() {
        homeRecyclerView.adapter = HomeRecyclerviewAdapter()
        homeRecyclerView.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
        var decoration = DividerItemDecoration(homeRecyclerView.context, 1)
        homeRecyclerView.addItemDecoration(decoration)
    }

    override fun initData() {
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    companion object {
        fun newInstance() = MainHomeFragment()
    }

    class HomeRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.row_board_cell, parent, false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){

        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

    }
}
