package com.withever.blind.ui.main.fragment

import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.jay.widget.StickyHeadersLinearLayoutManager
import com.withever.blind.R
import com.withever.blind.base.BaseFragment
import com.withever.blind.base.recyclerview.Item
import com.withever.blind.base.recyclerview.ListViewItemType
import com.withever.blind.databinding.FragmentMainHomeBinding
import com.withever.blind.ui.adapter.LoungeCategoryPagerAdapter
import com.withever.blind.ui.adapter.PostListRecyclerviewAdapter
import com.withever.blind.ui.data.PostingAttributeData
import com.withever.blind.ui.data.PostingSimpleData
import kotlinx.android.synthetic.main.fragment_main_home.*

class MainHomeFragment : BaseFragment<FragmentMainHomeBinding>() {

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
        initRecyclerView()
        initCategoryViewPager()
    }

    private fun initRecyclerView(){
        binding?.homeRecyclerView?.adapter = PostListRecyclerviewAdapter()
        binding?.homeRecyclerView?.layoutManager = StickyHeadersLinearLayoutManager<PostListRecyclerviewAdapter>(context)
        var decoration = DividerItemDecoration(binding?.homeRecyclerView?.context, 1)
        binding?.homeRecyclerView?.addItemDecoration(decoration)
    }

    private fun initCategoryViewPager(){
        binding?.pagerCategory?.clipToPadding = false
        binding?.pagerCategory?.adapter = LoungeCategoryPagerAdapter()
        binding?.pagerCategoryDot?.setViewPager(binding?.pagerCategory)
    }

    override fun initData() {
        val adapter = homeRecyclerView.adapter as PostListRecyclerviewAdapter

        val imageBanner: Item<*> = Item(ListViewItemType.ViewTypeHomeImageBanner.id, null)
        adapter.addItem(imageBanner)

        val sortingFilter: Item<*> = Item(ListViewItemType.ViewTypeCommonSortingFilter.id, null)
        adapter.addItem(sortingFilter)

        for(i in 1..15 step 1){
            val data: PostingSimpleData = PostingSimpleData(""+i, ""+(i+1), ""+(i+2), ""+(i+3),"아는 지인이 스타으업으로 오퍼가 왔다는데, 처음 가는거라 연봉땜에 갈지말지 고민\n처음 가는거라 연봉땜에 갈지말지 고민"+(i+4), i+5, i+6, PostingAttributeData(i+7, i+8, i+9, true))
            var item : Item<PostingSimpleData> = Item<PostingSimpleData>(ListViewItemType.ViewTypeSimplePostingCell.id, data)
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