package com.withever.blind.extension.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentManager.detach(layoutID: Int) {
    findFragmentById(layoutID)?.also {
        beginTransaction().detach(it).commit()
    }
}

fun FragmentManager.attach(layoutID: Int, fragment: Fragment, tag: String) {
    if (fragment.isDetached) {
        beginTransaction().attach(fragment).commit()
    } else {
        beginTransaction().add(layoutID, fragment, tag).commit()
    }
    // Set a transition animation for this transaction.
    beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
}
