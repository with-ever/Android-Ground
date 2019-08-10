package com.withever.blind.base

import android.content.Context

open class BaseManager<L : BaseManagerListener>(var context: Context){

    var listener : L? = null

    fun initListener(listener: L?) {
        this.listener = listener
    }

}