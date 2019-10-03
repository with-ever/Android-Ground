package com.withever.blind.base.recyclerview

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

open abstract class BaseViewHolder<ITEM>(view: View) : RecyclerView.ViewHolder(view){

    protected  var context: Context
    private var viewType: Int = 0
    private var onRecyclerViewItemListener: OnRecyclerViewItemListener? = null

    init {
        context = view.context

        onInitView()
    }

    abstract fun onBindView(item: ITEM?)
    abstract fun onInitView()
}