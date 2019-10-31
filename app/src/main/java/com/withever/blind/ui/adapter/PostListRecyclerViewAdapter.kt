package com.withever.blind.ui.adapter

import android.view.ViewGroup
import com.jay.widget.StickyHeaders
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.base.recyclerview.ListViewItemType
import com.withever.blind.ui.viewholder.ImageBannerViewHolder
import com.withever.blind.ui.viewholder.PostListRecyclerViewHolder
import com.withever.blind.ui.viewholder.SortingFilterViewHolder

class PostListRecyclerviewAdapter : BaseRecyclerViewAdapter(), StickyHeaders {

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        when(viewType){
            ListViewItemType.ViewTypeHomeImageBanner.id ->
                return ImageBannerViewHolder(bindingInflate(parent, R.layout.layout_image_banner))

            ListViewItemType.ViewTypeCommonSortingFilter.id ->
                return SortingFilterViewHolder(bindingInflate(parent, R.layout.layout_sorting_filter))

            else ->
                return PostListRecyclerViewHolder(bindingInflate(parent, R.layout.row_board_cell))
        }

    }

    override fun isStickyHeader(position: Int): Boolean {
        if(position >= getRealItemCount()) return false

        when(getAllItem()[position].viewType){
            ListViewItemType.ViewTypeHomeImageBanner.id -> return true
            ListViewItemType.ViewTypeCommonSortingFilter.id -> return true
        }

        return false
    }
}