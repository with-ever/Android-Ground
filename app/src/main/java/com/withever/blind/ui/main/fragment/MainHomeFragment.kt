package com.withever.blind.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import com.withever.blind.base.recyclerview.Item
import com.withever.blind.databinding.FragmentMainHomeBinding
import com.withever.blind.ui.adapter.PostListRecyclerviewAdapter
import com.withever.blind.ui.data.PostingAttributeData
import com.withever.blind.ui.data.PostingSimpleData
import kotlinx.android.synthetic.main.fragment_main_home.*

class MainHomeFragment : BaseFragment() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId() = R.layout.fragment_main_home

    var binding: FragmentMainHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        initLayout()

        return binding!!.root
    }

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
        binding?.homeRecyclerView?.adapter = PostListRecyclerviewAdapter()
        var decoration = DividerItemDecoration(binding?.homeRecyclerView?.context, 1)
        binding?.homeRecyclerView?.addItemDecoration(decoration)
    }

    override fun initData() {
        val adapter = homeRecyclerView.adapter as PostListRecyclerviewAdapter

        for(i in 1..15 step 1){
            val data: PostingSimpleData = PostingSimpleData(""+i, ""+(i+1), ""+(i+2), ""+(i+3),"아는 지인이 스타으업으로 오퍼가 왔다는데, 처음 가는거라 연봉땜에 갈지말지 고민\n처음 가는거라 연봉땜에 갈지말지 고민"+(i+4), i+5, i+6, PostingAttributeData(i+7, i+8, i+9, true))
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