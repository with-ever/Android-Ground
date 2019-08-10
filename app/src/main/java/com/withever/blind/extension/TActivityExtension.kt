package com.withever.blind.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat

/**----------------------------------------------------
 * Activity intent
 *----------------------------------------------------*/
inline fun <reified T : Any> Activity.start(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.init()

    if (Build.VERSION_CODES.JELLY_BEAN <= Build.VERSION.SDK_INT) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }
}

inline fun <reified T : Any> Context.start(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.init()

    if (Build.VERSION_CODES.JELLY_BEAN <= Build.VERSION.SDK_INT) {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}


/**----------------------------------------------------
 * Activity transition
 *----------------------------------------------------*/
fun Activity.createTransition(view: View): ActivityOptionsCompat? {
    return ActivityOptionsCompat.makeSceneTransitionAnimation(
        this,
        view,
        ViewCompat.getTransitionName(view)!!
    )
}

fun Context.createTransition(view: View): ActivityOptionsCompat? {
    return ActivityOptionsCompat.makeSceneTransitionAnimation(
        this as Activity,
        view,
        ViewCompat.getTransitionName(view)!!
    )
}

//fun Context.createTransition(vararg view: View): ActivityOptionsCompat? {
//    val array: MutableList<Pair<View, String>> = mutableListOf()
//    view.mapTo(array) { Pair.create(it, ViewCompat.getTransitionName(it)) }
//    return ActivityOptionsCompat.makeSceneTransitionAnimation(
//        this as Activity,
//        *array.toTypedArray()
//    )
//}

