package com.withever.blind.ui.adapter

import android.view.ViewGroup
import com.jay.widget.StickyHeaders
import com.withever.blind.R
import com.withever.blind.base.recyclerview.BaseRecyclerViewAdapter
import com.withever.blind.base.recyclerview.BaseViewHolder
import com.withever.blind.base.recyclerview.ListViewItemType
import com.withever.blind.ui.viewholder.PostingTitleViewHolder
import com.withever.blind.ui.viewholder.SortingFilterViewHolder

class PostingDetailRecyclerViewAdapter : BaseRecyclerViewAdapter(), StickyHeaders {

    override fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        when(viewType){
            ListViewItemType.ViewTypePostingDetailTitle.id ->
                return PostingTitleViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))

            ListViewItemType.ViewTypePostingDetailText.id ->
                return SortingFilterViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))

            ListViewItemType.ViewTypePostingDetailImage.id ->
                return SortingFilterViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))

            ListViewItemType.ViewTypePostingDetailInfo.id ->
                return SortingFilterViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))

            ListViewItemType.ViewTypeCommonSortingFilter.id ->
                return SortingFilterViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))

            else->
                return SortingFilterViewHolder( bindingInflate(parent, R.layout.layout_sorting_filter))
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