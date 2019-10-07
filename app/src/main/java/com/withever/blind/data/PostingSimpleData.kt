package com.withever.blind.data

data class PostingSimpleData(val title: String,
                             val companyName: String,
                             val userNickName: String,
                             val previewIamgeURL: String,
                             val contents: String,
                             val viewCount: Int,
                             val writeTime: Int,
                             val likeCount: Int,
                             val commentCount: Int,
                             val sharedCount: Int){
}