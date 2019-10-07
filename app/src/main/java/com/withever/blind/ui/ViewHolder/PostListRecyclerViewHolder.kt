package com.withever.blind.ui.ViewHolder

import android.view.View
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.data.PostingSimpleData
import com.withever.blind.databinding.RowBoardCellBinding

class PostListRecyclerViewHolder(view: View, binding: RowBoardCellBinding?) : BaseViewHolder<PostingSimpleData>(view){

    val binding: RowBoardCellBinding? = binding

    override fun onBindView(item: PostingSimpleData?) {
        binding?.postingSimple = item
        binding?.titleTest = "asdasd"
    }

    override fun onInitView() {

    }
}