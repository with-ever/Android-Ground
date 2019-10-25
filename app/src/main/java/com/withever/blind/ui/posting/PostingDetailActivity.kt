package com.withever.blind.ui.posting

import android.os.Bundle
import android.widget.ArrayAdapter
import com.withever.blind.R
import com.withever.blind.base.BaseActivity

import com.withever.blind.databinding.ActivityPostingDetailBinding
import com.withever.blind.ui.data.PostingSimpleData
import kotlinx.android.synthetic.main.activity_main.*

class PostingDetailActivity : BaseActivity<ActivityPostingDetailBinding>() {

    var postingData: PostingSimpleData? = null

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
        var categoryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getPostingCategoryList())
        //binding?.spinnerCategory?.adapter = categoryAdapter

        toolbar.addBackButtonAction {
            finish()
        }
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