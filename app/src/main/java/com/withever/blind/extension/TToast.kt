package com.withever.blind.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast

/**
 * Make a standard toast that just contains a text view.
 *
 * @param text     The text to show.  Can be formatted text.
 * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
 *                 {@link #LENGTH_LONG}
 *
 */
fun Activity.toast(text: String, duration: Int) {
    Toast.makeText(this, text, duration).show();
}

/**
 * Make a standard toast that just contains a text view.
 *
 * @param text     The text to show.  Can be formatted text.
 */
fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
}

/**
 * Make a standard toast that just contains a text view.
 *
 * @param text     The text to show.  Can be formatted text.
 * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
 *                 {@link #LENGTH_LONG}
 *
 */
fun Context.toast(text: String, duration: Int) {
    Toast.makeText(this, text, duration).show();
}

/**
 * Make a standard toast that just contains a text view.
 *
 * @param text     The text to show.  Can be formatted text.
 */
fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
}
