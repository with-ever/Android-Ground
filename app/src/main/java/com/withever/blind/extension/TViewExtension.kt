package com.withever.blind.extension

import android.app.Activity
import android.view.View
import androidx.annotation.LayoutRes

fun Activity.inflate(@LayoutRes layout: Int): View = this.layoutInflater.inflate(layout, null)

fun View.visible(isShow: Boolean) {
    if (isShow) {
        visible()
    } else {
        gone()
    }
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.isShow() : Boolean {
    return this.visibility == View.VISIBLE
}

fun View.isHide() : Boolean {
    return this.visibility != View.VISIBLE
}

fun View.runUi(action: (()-> Unit)) {
    (context as Activity).runOnUiThread {
        action.invoke()
    }
}