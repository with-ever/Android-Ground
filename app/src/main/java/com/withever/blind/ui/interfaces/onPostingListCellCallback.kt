package com.withever.blind.ui.interfaces

import com.withever.blind.ui.data.PostingSimpleData

interface IPostingListCellCallback {
    fun onClickPostingListCell(postingData: PostingSimpleData)
}