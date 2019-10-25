package com.withever.blind.base.recyclerview

data class Item<out ITEM>(val viewType: Int, val item: ITEM)

enum class ListViewItemType(val id: Int) {
    ViewTypeImageBanner(1),
    ViewTypeSortingFilter(2),
    ViewTypeSimplePostingCell(3);
}