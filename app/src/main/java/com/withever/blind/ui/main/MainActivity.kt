package com.withever.blind.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.withever.blind.R
import com.withever.blind.base.BaseActivity
import com.withever.blind.extension.view.active
import com.withever.blind.extension.view.attach
import com.withever.blind.extension.view.detach
import com.withever.blind.ui.main.navigation.MainNavigation
import com.withever.blind.ui.main.navigation.createFragment
import com.withever.blind.ui.main.navigation.findNavigationPositionById
import com.withever.blind.ui.main.navigation.getTag
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var mainNavigation: MainNavigation = MainNavigation.HOME

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        initData()
    }

    override fun onResume() {
        super.onResume()
    }


    /**----------------------------------------------------
     * Initialize
     *----------------------------------------------------*/
    override fun initLayout() {
        bottomNavigation.apply {
            active(mainNavigation.position)
            setOnNavigationItemSelectedListener { item ->
                mainNavigation = findNavigationPositionById(item.itemId)
                switchFragment(mainNavigation)
            }
        }
        // 처음 화면 설정
        switchFragment(MainNavigation.HOME)
    }

    override fun initData() {

    }



    /**
     * Immediately execute transactions with FragmentManager#executePendingTransactions.
     */
    private fun switchFragment(navigation: MainNavigation): Boolean {
        return findFragment(navigation).let {
            if (it.isAdded) return false
            supportFragmentManager.detach(R.id.container) // Extension function
            supportFragmentManager.attach(R.id.container, it, navigation.getTag()) // Extension function
            supportFragmentManager.executePendingTransactions()
        }
    }

    private fun findFragment(position: MainNavigation): Fragment {
        return supportFragmentManager.findFragmentByTag(position.getTag()) ?: position.createFragment()
    }

}
