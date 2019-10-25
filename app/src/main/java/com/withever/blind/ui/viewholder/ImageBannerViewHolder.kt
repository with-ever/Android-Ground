package com.withever.blind.ui.viewholder

import android.util.Log
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.databinding.LayoutImageBannerBinding
import com.withever.blind.ui.data.PostingSimpleData
import com.withever.blind.ui.interfaces.IPostingListCellCallback

class ImageBannerViewHolder(binding: LayoutImageBannerBinding) : BaseViewHolder<String>(binding.root)
                                                               , IPostingListCellCallback {

    val binding: LayoutImageBannerBinding

    init{
        this.binding = binding
    }

    override fun onBindView(item: String?) {
        Log.d("asdasd", "onBindView")
    }

    override fun onInitView() {
        Log.d("asdasd", "onInitView")
    }

    /**----------------------------------------------------
     * IPostingListCellCallback interface
     *----------------------------------------------------*/
    override fun onClickPostingListCell(postingData: PostingSimpleData) {
//        val data = Bundle()
//        data.putParcelable("postingSimpleData", postingData)
//        context.start<PostingActivity>(data)
    }
}