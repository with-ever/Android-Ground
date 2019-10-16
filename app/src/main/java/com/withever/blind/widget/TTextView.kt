package com.withever.blind.widget

import android.content.Context
import android.graphics.Paint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.view.ViewTreeObserver
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.withever.blind.R
import com.withever.blind.extension.isCheckEmpty

class TTextView (context: Context, attrs: AttributeSet): AppCompatTextView(context, attrs) {

    var strMore: String? = "more"
    var collapseLine: Int = 2
    var state: STATE = STATE.COLLAPSE
        set(value) {
            field = value
            checkOverLine()
        }
    var isOverLine: Boolean = false

    init{
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TTextView)
        strMore = typedArray.getString(R.styleable.TTextView_text_more)
        collapseLine = typedArray.getInt(R.styleable.TTextView_collapseLine, 0)

        typedArray.recycle()

        checkOverLine()
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

    /**----------------------------------------------------
     * expandable Text
     *----------------------------------------------------*/
    private fun checkOverLine(){
        if(collapseLine <= 0)
            return

        viewTreeObserver.addOnPreDrawListener(object: ViewTreeObserver.OnPreDrawListener{
            override fun onPreDraw(): Boolean {
                viewTreeObserver.removeOnPreDrawListener(this)

                if(lineCount > collapseLine){
                    isOverLine = true

                    val lineEndIndex = layout.getLineEnd(collapseLine)

                    when(state){
                        STATE.COLLAPSE -> appendMoreText(lineEndIndex)
                        STATE.EXPAND -> {
                            if(tag != null)
                                setString(tag.toString())
                            else
                                setString("error")
                        }
                    }
                }

                return true
            }
        })
    }

    private fun appendMoreText(lineEndIndex: Int){
        val expandText: SpannableString = createSpannableString(strMore)

        text = text.subSequence(0, lineEndIndex - expandText.length + 1)
        append("... ")
        append(expandText)

        setOnClickListener {
            val origin: String = tag.toString()
            setString(origin)
            state = STATE.EXPAND
        }
    }

    private fun createSpannableString(moreText: String?) : SpannableString{
        val spannableString = SpannableString(moreText!!)
        spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.gray_light))
                                , 0
                                , moreText.length
                                , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(UnderlineSpan(), 0, moreText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

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
}

