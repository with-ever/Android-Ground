package com.withever.blind.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jay.widget.StickyHeaders
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.base.recyclerview.ListViewItemType
import com.withever.blind.ui.viewholder.ImageBannerViewHolder
import com.withever.blind.ui.viewholder.PostListRecyclerViewHolder
import com.withever.blind.ui.viewholder.SortingFilterViewHolder

class PostListRecyclerviewAdapter : BaseRecyclerViewAdapter(), StickyHeaders {
    override fun getItemCount(): Int {
        return 14
    }

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        when(viewType){
            ListViewItemType.ViewTypeImageBanner.id ->

            return ImageBannerViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.layout_image_banner,
                    parent,
                    false
                )
            )

            ListViewItemType.ViewTypeSortingFilter.id ->
            return SortingFilterViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.layout_sorting_filter,
                    parent,
                    false
                )
            )


            else ->
            return PostListRecyclerViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.row_board_cell,
                    parent,
                    false
                )
            )
        }

    }

    override fun isStickyHeader(position: Int): Boolean {
        if(position >= getRealItemCount()) return false

        return (getAllItem()[position].viewType == 0)
    }
}