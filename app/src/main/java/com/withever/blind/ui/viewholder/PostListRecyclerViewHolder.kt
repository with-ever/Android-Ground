package com.withever.blind.ui.viewholder

import android.util.Log
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.RowBoardCellBinding
import com.withever.blind.ui.data.PostingSimpleData

class PostListRecyclerViewHolder(binding: RowBoardCellBinding) : BaseViewHolder<PostingSimpleData>(binding.root){

    val binding: RowBoardCellBinding

    init{
        this.binding = binding
    }

    override fun onBindView(item: PostingSimpleData?) {
        Log.d("asdasd", "onBindView")
        binding.simplePostingData = item
    }

    override fun onInitView() {
        Log.d("asdasd", "onInitView")
    }
}