package com.withever.blind.ui.main.fragment

import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import com.withever.blind.ui.adapter.PostListRecyclerviewAdapter
import kotlinx.android.synthetic.main.fragment_main_bookmark.*

class MainBookmarkFragment : BaseFragment() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId() = R.layout.fragment_main_bookmark
    override fun createView(viewGroup: ViewGroup?) {

    }

    override fun onResume() {
        super.onResume()
        initLayout()
        initData()
    }

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun initLayout() {
        bookmarkRecyclerView.adapter = PostListRecyclerviewAdapter()
        bookmarkRecyclerView.layoutManager = LinearLayoutManager(activity)
        var decoration = DividerItemDecoration(bookmarkRecyclerView.context, 1)
        bookmarkRecyclerView.addItemDecoration(decoration)
    }

    override fun initData() {
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    companion object {
        fun newInstance() = MainBookmarkFragment()
    }


}
