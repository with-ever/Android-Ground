package com.withever.blind.ui.main.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import com.withever.blind.base.recyclerview.Item
import com.withever.blind.ui.Adapter.PostListRecyclerviewAdapter
import com.withever.blind.ui.data.PostingSimpleData
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
        var decoration = DividerItemDecoration(homeRecyclerView.context, 1)
        homeRecyclerView.addItemDecoration(decoration)
    }

    override fun initData() {
        val adapter = homeRecyclerView.adapter as PostListRecyclerviewAdapter

        for(i in 1..15 step 1){
            val data: PostingSimpleData = PostingSimpleData(""+i, ""+(i+1), ""+(i+2), ""+(i+3),""+(i+4), i+5, i+6, i+7, i+8, i+9)
            var item : Item<PostingSimpleData> = Item<PostingSimpleData>(1, data)
            adapter.addItem(item)
        }
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    companion object {
        fun newInstance() = MainHomeFragment()
    }
}