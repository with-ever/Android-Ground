package com.withever.blind.ui.posting

import android.os.Bundle
import com.jay.widget.StickyHeadersLinearLayoutManager
import com.withever.blind.R
import com.withever.blind.base.BaseActivity
import com.withever.blind.base.recyclerview.Item
import com.withever.blind.base.recyclerview.ListViewItemType
import com.withever.blind.databinding.ActivityPostingDetailBinding
import com.withever.blind.ui.adapter.PostListRecyclerviewAdapter
import com.withever.blind.ui.adapter.PostingDetailRecyclerViewAdapter
import com.withever.blind.ui.data.PostingSimpleData
import kotlinx.android.synthetic.main.activity_main.*

class PostingDetailActivity : BaseActivity<ActivityPostingDetailBinding>() {

    var postingData: PostingSimpleData? = null
    var adapter: PostingDetailRecyclerViewAdapter? = null

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId(): Int = R.layout.activity_posting_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        initData()
    }

    override fun onResume() {
        super.onResume()
    }


    /**----------------------------------------------------
     * Initialize
     *----------------------------------------------------*/
    override fun initLayout() {

        initRecyclerView()
        initPostingTitle()
        //initPostingInfo()
        initPostingFilter()

        toolbar.addBackButtonAction {
            finish()
        }
    }

    private fun initRecyclerView(){
        binding?.recyclerView?.adapter = PostingDetailRecyclerViewAdapter()
        binding?.recyclerView?.layoutManager = StickyHeadersLinearLayoutManager<PostListRecyclerviewAdapter>(this)

        adapter = binding?.recyclerView?.adapter as PostingDetailRecyclerViewAdapter
    }

    private fun initPostingTitle(){
        val postingTitle: Item<*> = Item(ListViewItemType.ViewTypePostingDetailTitle.id, null)

        adapter?.addItem(postingTitle)
    }

    private fun initPostingInfo(){
        val postingTitle: Item<*> = Item(ListViewItemType.ViewTypePostingDetailInfo.id, null)

        adapter?.addItem(postingTitle)
    }

    private fun initPostingFilter(){
        val adapter = binding?.recyclerView?.adapter as PostingDetailRecyclerViewAdapter
        val postingTitle: Item<*> = Item(ListViewItemType.ViewTypeCommonSortingFilter.id, null)

        adapter.addItem(postingTitle)
    }

    override fun initData() {

    }

    fun getPostingCategoryList(): Array<String>{
        return arrayOf(resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_DEVELOPER.descriptionID)
            ,resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_DESIGNER.descriptionID)
            ,resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_SERVICE.descriptionID)
            ,resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_MEROOMONG.descriptionID)
            ,resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_TED.descriptionID)
            ,resources.getString(PostingWriteActivity.PostingCategory.LOUNGE_HENRY.descriptionID))

    }

    enum class PostingCategory(val id: Int, val descriptionID: Int) {
        LOUNGE_DEVELOPER(0, R.string.lounge_developer),
        LOUNGE_DESIGNER(1, R.string.lounge_designer),
        LOUNGE_SERVICE(2, R.string.lounge_service),
        LOUNGE_MEROOMONG(3, R.string.lounge_meroomong),
        LOUNGE_TED(4, R.string.lounge_ted),
        LOUNGE_HENRY(5, R.string.lounge_henry)
    }
}