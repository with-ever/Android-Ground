package com.madsquare.chariscommerce.base

import android.text.Editable
import android.text.TextWatcher

class TTextWatcher : TextWatcher {
    private var onTextChanged : (() -> Unit)? = null
    private var beforeTextChanged : (() -> Unit)? = null
    private var afterTextChanged : (() -> Unit)? = null


    fun textChanged(listener : () -> Unit) : TTextWatcher {
        onTextChanged = listener
        return this
    }

    fun before(listener : () -> Unit) : TTextWatcher {
        beforeTextChanged = listener
        return this
    }

    fun after(listener : () -> Unit) : TTextWatcher {
        afterTextChanged = listener
        return this
    }

    override fun afterTextChanged(p0: Editable?) {
        afterTextChanged?.let { it() }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        beforeTextChanged?.let { it() }
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged?.let { it() }
    }
}