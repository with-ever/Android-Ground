package com.withever.blind.base.recyclerview

data class Item<out ITEM>(val viewType: Int, val item: ITEM)

enum class ListViewItemType(val id: Int) {
    ViewTypeCommonSortingFilter(2),

    ViewTypeHomeImageBanner(1),
    ViewTypeSimplePostingCell(3),

    ViewTypePostingDetailTitle(4),
    ViewTypePostingDetailText(5),
    ViewTypePostingDetailImage(6),
    ViewTypePostingDetailInfo(7)
}