package com.withever.blind.base.recyclerview

/**
 * Created by ted on 2018. 2. 6..
 */
interface OnRecyclerViewItemListener {
    fun clickItem(position: Int, viewType: Int, viewId: Int, item: Any)
}