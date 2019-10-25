package com.withever.blind.ui.viewholder

import android.os.Bundle
import android.util.Log
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.RowBoardCellBinding
import com.withever.blind.extension.start
import com.withever.blind.ui.data.PostingSimpleData
import com.withever.blind.ui.interfaces.IPostingListCellCallback
import com.withever.blind.ui.posting.PostingWriteActivity

class PostListRecyclerViewHolder(binding: RowBoardCellBinding) : BaseViewHolder<PostingSimpleData>(binding.root)
                                                               , IPostingListCellCallback {

    val binding: RowBoardCellBinding

    init{
        this.binding = binding
        this.binding.postingListViewHolder = this
    }

    override fun onBindView(item: PostingSimpleData?) {
        Log.d("asdasd", "onBindView")
        binding.simplePostingData = item
    }

    override fun onInitView() {
        Log.d("asdasd", "onInitView")
    }

    /**----------------------------------------------------
     * IPostingListCellCallback interface
     *----------------------------------------------------*/
    override fun onClickPostingListCell(postingData: PostingSimpleData) {
        val data = Bundle()
        data.putParcelable("postingSimpleData", postingData)
        context.start<PostingWriteActivity>(data)
    }
}