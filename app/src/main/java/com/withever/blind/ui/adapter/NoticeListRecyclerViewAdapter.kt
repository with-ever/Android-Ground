package com.withever.blind.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.RowNoticeCellBinding
import com.withever.blind.ui.data.PostingSimpleData
import com.withever.blind.ui.viewholder.NoticeListRecyclerViewHolder

class NoticeListRecyclerviewAdapter : BaseRecyclerViewAdapter() {
    override fun getItemCount(): Int {
        return 14
    }

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PostingSimpleData> {
        val binding: RowNoticeCellBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_notice_cell,
            parent,
            false
        )

        return NoticeListRecyclerViewHolder(binding)
    }
}