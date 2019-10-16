package com.withever.blind.ui.data

data class PostingSimpleData(val title: String,
                             val companyName: String,
                             val userNickName: String,
                             val previewIamgeURL: String,
                             val contents: String,
                             val viewCount: Int,
                             val writeTime: Int,
                             val postingAttrData: PostingAttributeData)

data class PostingAttributeData(val likeCount: Int,
                                val commentCount: Int,
                                val sharedCount: Int,
                                val isBookmark: Boolean)