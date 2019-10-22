package com.withever.blind.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T :ViewDataBinding> : Fragment() {

    var binding: T? = null

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initLayout()
    abstract fun initData()
    abstract fun createView(viewGroup: ViewGroup?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        createView(binding?.root as ViewGroup)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}