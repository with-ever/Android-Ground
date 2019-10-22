package com.withever.blind.ui.main.fragment

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.withever.blind.R
import com.withever.blind.base.BaseFragment

class MainMyFragment : BaseFragment<ViewDataBinding>() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId() = R.layout.fragment_main_my
    override fun createView(viewGroup: ViewGroup?) {
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun initLayout() {
    }

    override fun initData() {
    }


    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    companion object {
        fun newInstance() = MainMyFragment()
    }
}
