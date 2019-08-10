package com.withever.blind.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.withever.blind.R
import com.withever.blind.extension.gone
import com.withever.blind.extension.visible
import kotlinx.android.synthetic.main.layout_ttoolbar.view.*

class TToolBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    var toolbarTitle: String? = ""
    var toolbarStyle: Int? = 2
    private var actionBackButton: (() -> Unit)? = null

    init {
        View.inflate(context, R.layout.layout_ttoolbar, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TToolBar)
        toolbarTitle = typedArray.getString(R.styleable.TToolBar_toolbar_title)
        toolbarStyle = typedArray.getInt(R.styleable.TToolBar_toolbar_style, 2)
        typedArray.recycle()

        initLayout()
    }

    private fun initLayout() {
        textTToolbarTitle.text = toolbarTitle
        imgTToolbarBack.setOnClickListener {
            actionBackButton?.invoke()
        }

        when (toolbarStyle) {
            // default style
            1 -> {
                imgTToolbarBack.gone()
                textTToolbarTitle.text = "Blind"
            }
            // back button style
            2 -> {
                imgTToolbarBack.visible()
            }
        }
    }

    fun addBackButtonAction(action: () -> Unit) {
        actionBackButton = action
    }

    fun setToolBarTitle(title: String) {
        textTToolbarTitle.text = title
    }

}