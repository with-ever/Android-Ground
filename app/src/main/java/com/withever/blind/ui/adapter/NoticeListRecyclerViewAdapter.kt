package com.withever.blind.ui.adapter

import android.view.ViewGroup
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.ui.data.PostingSimpleData
import com.withever.blind.ui.viewholder.NoticeListRecyclerViewHolder

class NoticeListRecyclerviewAdapter : BaseRecyclerViewAdapter() {
    override fun getItemCount(): Int {
        return 14
    }

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PostingSimpleData> {
        return NoticeListRecyclerViewHolder(bindingInflate(parent, R.layout.row_notice_cell))
    }
}