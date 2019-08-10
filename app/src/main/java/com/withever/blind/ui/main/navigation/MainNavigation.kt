package com.withever.blind.ui.main.navigation

import androidx.fragment.app.Fragment
import com.withever.blind.R
import com.withever.blind.ui.main.fragment.*


enum class MainNavigation(val position: Int, val id: Int) {
    HOME(0, R.id.menu_home),
    SEARCH(1, R.id.menu_search),
    WRITE(2, R.id.menu_write),
    BOOKMARK(3, R.id.menu_bookmark),
    MY(4, R.id.menu_my);
}

fun findNavigationPositionById(id: Int): MainNavigation = when (id) {
    MainNavigation.HOME.id -> MainNavigation.HOME
    MainNavigation.SEARCH.id -> MainNavigation.SEARCH
    MainNavigation.WRITE.id -> MainNavigation.WRITE
    MainNavigation.BOOKMARK.id -> MainNavigation.BOOKMARK
    MainNavigation.MY.id -> MainNavigation.MY
    else -> MainNavigation.HOME
}

fun MainNavigation.createFragment(): Fragment = when (this) {
    MainNavigation.HOME -> MainHomeFragment.newInstance()
    MainNavigation.SEARCH -> MainSearchFragment.newInstance()
    MainNavigation.WRITE -> MainWriteFragment.newInstance()
    MainNavigation.BOOKMARK -> MainBookmarkFragment.newInstance()
    MainNavigation.MY -> MainMyFragment.newInstance()
}

fun MainNavigation.getTag(): String = when (this) {
    MainNavigation.HOME -> MainHomeFragment::class.java.simpleName
    MainNavigation.SEARCH -> MainSearchFragment::class.java.simpleName
    MainNavigation.WRITE -> MainWriteFragment::class.java.simpleName
    MainNavigation.BOOKMARK -> MainBookmarkFragment::class.java.simpleName
    MainNavigation.MY -> MainMyFragment::class.java.simpleName
}
