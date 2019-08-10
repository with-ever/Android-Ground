package com.withever.blind.base.recyclerview

data class Item<out ITEM>(val viewType: Int, val item: ITEM)