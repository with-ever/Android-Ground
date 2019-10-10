package com.withever.blind.ui.ViewHolder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.RowBoardCellBinding
import com.withever.blind.extension.isLogDebug
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