package com.withever.blind.ui.main.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import com.withever.blind.ui.Adapter.PostListRecyclerviewAdapter
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
        homeRecyclerView.adapter = PostListRecyclerviewAdapter()
        homeRecyclerView.layoutManager =
            LinearLayoutManager(activity) as RecyclerView.LayoutManager?
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
}