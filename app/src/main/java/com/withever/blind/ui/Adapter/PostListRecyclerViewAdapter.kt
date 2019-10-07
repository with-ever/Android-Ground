package com.withever.blind.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.databinding.RowBoardCellBinding
import com.withever.blind.ui.ViewHolder.PostListRecyclerViewHolder

class PostListRecyclerviewAdapter : BaseRecyclerViewAdapter(){

    var binding : RowBoardCellBinding? = null

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): PostListRecyclerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_board_cell, parent, false)

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_board_cell, parent, false)
        return PostListRecyclerViewHolder(view, binding)
    }

    override fun getItemCount(): Int {
        return 14
    }

}