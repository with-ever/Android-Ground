package com.withever.blind.extension

fun String?.checkEmpty(): String {
    return if (android.text.TextUtils.isEmpty(this)) "" else this!!
}

fun String?.isCheckEmpty(): Boolean {
    return !android.text.TextUtils.isEmpty(this)
}