package com.withever.blind.ui.main.fragment

import android.view.ViewGroup
import com.withever.blind.R
import com.withever.blind.base.BaseFragment

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
//        imgTemp.load("http://cdnweb01.wikitree.co.kr/webdata/editor/201906/01/img_20190601102948_91ae1835.jpg", null)
//        imgTemp2.loadImageCallback("http://cdnweb01.wikitree.co.kr/webdata/editor/201906/01/img_20190601102948_91ae1835.jpg", object: ImageLoadListener{
//            override fun success() {}
//            override fun failed() {}
//        })
//        textTemp.setString("테스트")
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
