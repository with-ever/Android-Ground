package com.withever.blind.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jay.widget.StickyHeaders
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.RowBoardCellBinding
import com.withever.blind.ui.data.PostingSimpleData
import com.withever.blind.ui.viewholder.PostListRecyclerViewHolder

class PostListRecyclerviewAdapter : BaseRecyclerViewAdapter(), StickyHeaders {
    override fun getItemCount(): Int {
        return 14
    }

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PostingSimpleData> {
        val binding: RowBoardCellBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_board_cell,
            parent,
            false
        )

        return PostListRecyclerViewHolder(binding)
    }

    override fun isStickyHeader(position: Int): Boolean {
        if(position >= getRealItemCount()) return false

        return (getAllItem()[position].viewType == 0)
    }
}