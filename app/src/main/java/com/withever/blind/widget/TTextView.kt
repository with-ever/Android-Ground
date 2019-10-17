package com.withever.blind.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.withever.blind.R
import com.withever.blind.extension.isCheckEmpty

class TTextView (context: Context, attrs: AttributeSet): AppCompatTextView(context, attrs) {

    var strMore: String? = "more"
    var collapseLine: Int = 2
    var colorMore = Color.BLACK

    init{
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TTextView)
        strMore = typedArray.getString(R.styleable.TTextView_text_more)
        collapseLine = typedArray.getInt(R.styleable.TTextView_collapseLine, 0)
        colorMore = typedArray.getColor(R.styleable.TTextView_color_text_more, Color.BLACK)

        typedArray.recycle()
    }

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

    fun isContentsChanged(cs1: CharSequence, cs2: CharSequence): Boolean{
        val length = cs1.length
        if (length != cs2.length) {
            return true
        }
        for (i in 0 until length) {
            if (cs1[i] != cs2[i]) {
                return true
            }
        }
        return false
    }

    /**----------------------------------------------------
     * expandable Text
     *----------------------------------------------------*/
    fun getMaximumText(t: CharSequence): CharSequence{
        if(collapseLine <= 0)
            return t

        if(lineCount > collapseLine){
            val lineEndIndex = layout.getLineEnd(collapseLine)
            return appendMoreText(t, lineEndIndex)
        }

        return t
    }

    private fun appendMoreText(t: CharSequence, lineEndIndex: Int): CharSequence{
        val expandText: SpannableString = createSpannableString(strMore)
        val strAfter = t.subSequence(0, lineEndIndex - expandText.length + 1)
        val strBiulder: StringBuilder = StringBuilder(strAfter).append("... ").append(expandText)

        return strBiulder.toString()
    }

    private fun createSpannableString(moreText: String?) : SpannableString{
        val spannableString = SpannableString(moreText!!)
        spannableString.setSpan(ForegroundColorSpan(colorMore)
                                , 0
                                , moreText.length
                                , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    /**----------------------------------------------------
     * Style
     *----------------------------------------------------*/
    fun underline() {
        paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }

    /**----------------------------------------------------
     * Enum
     *----------------------------------------------------*/
    enum class STATE(val id: Int){
        COLLAPSE(1),
        EXPAND(2)
    }

    companion object {
        @BindingAdapter("bind:textWithMaximumLine")
        @JvmStatic
        fun setTextAfterCheckMaximumLine(tv: TTextView, t: String) {
            tv.text = t
            tv.text = tv.getMaximumText(t)
        }
    }
}

