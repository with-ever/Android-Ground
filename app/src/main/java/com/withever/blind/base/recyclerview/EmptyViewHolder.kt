package com.withever.blind.base.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.withever.blind.R

class EmptyViewHolder(view: View) : BaseViewHolder<Any>(view) {

    override fun onBindView(item: Any) {}
    override fun onInitView() {}

    companion object {
        fun create(parent: ViewGroup?): EmptyViewHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_empty, parent, false)
            return EmptyViewHolder(view)
        }
    }
}