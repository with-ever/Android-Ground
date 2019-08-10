package com.withever.blind.ui.posting

import android.os.Bundle
import com.withever.blind.R
import com.withever.blind.base.BaseActivity

class PostingActivity : BaseActivity() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId(): Int = R.layout.activity_posting

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

    }

    override fun initData() {

    }


}