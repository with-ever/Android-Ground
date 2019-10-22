package com.withever.blind.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.withever.blind.R
import com.withever.blind.extension.hideSoftKeyboard
import com.withever.blind.utils.language.LanguageHelper
import com.withever.blind.utils.language.changeLanguage
import com.withever.blind.utils.language.getLocalLanguage
import com.withever.blind.utils.language.getLocale


abstract class BaseActivity<T : ViewDataBinding>: AppCompatActivity() {

    var binding: T? = null

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initLayout()
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_left_out)
        super.onCreate(savedInstanceState)
        hideSoftKeyboard()

        val localLang = getLocalLanguage()
        if (!localLang.isNullOrEmpty()) {
            changeLanguage(baseContext, getLocale(localLang))
        }

        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun attachBaseContext(newBase: Context) {
        val newContext = LanguageHelper.onAttach(newBase)
        super.attachBaseContext(newContext)
    }

    override fun finish() {
        super.finish()
        hideSoftKeyboard()
        overridePendingTransition(R.anim.anim_right_out, R.anim.anim_right_in)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}