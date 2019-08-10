package com.withever.blind.extension

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


/**----------------------------------------------------
 * Keyboard
 *----------------------------------------------------*/
fun Context.hideSoftKeyboard() {
    val activity = (this as Activity)
    val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentFocus = activity.currentFocus
    if (currentFocus != null) {
        inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}


/**----------------------------------------------------
 * Screen
 *----------------------------------------------------*/
fun Context.screenHeight(): Int {
    val width = this.resources.displayMetrics.widthPixels
    val height = this.resources.displayMetrics.heightPixels
    return if (width > height) {
        width
    } else {
        height
    }
}

fun Context.screenWidth(): Int {
    val width = this.resources.displayMetrics.widthPixels
    val height = this.resources.displayMetrics.heightPixels
    return if (width < height) {
        width
    } else {
        height
    }
}

