package com.withever.blind.widget

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.withever.blind.extension.isCheckEmpty

class TTextView (context: Context, attrs: AttributeSet): AppCompatTextView(context, attrs) {

    /**----------------------------------------------------
     * Set string
     *----------------------------------------------------*/
    fun setString(string: String?) {
        text = if (string.isCheckEmpty()) {
            string
        } else {
            ""
        }
    }

    fun setString(resId: Int) {
        text = resources.getString(resId)
    }

    /**----------------------------------------------------
     * Style
     *----------------------------------------------------*/
    fun underline() {
        paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }
}

