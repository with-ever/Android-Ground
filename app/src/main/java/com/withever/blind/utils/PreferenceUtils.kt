package com.withever.blind.utils

import android.content.Context
import com.withever.blind.application.BlindApplication

object PreferencesUtils {

    private const val NAME = "WithEver"

    fun saveInt(key: String, value: Int) {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putInt(key, value)
        edit.apply()
    }

    fun saveString(key: String, value: String) {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString(key, value)
        edit.apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putBoolean(key, value)
        edit.apply()
    }

    fun saveLong(key: String, value: Long) {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString(key, java.lang.Long.toString(value))
        edit.apply()
    }

    fun loadInt(key: String, defaultValue: Int): Int {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getInt(key, defaultValue)
    }

    fun loadString(key: String, defaultValue: String): String? {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getString(key, defaultValue)
    }


    fun loadBoolean(key: String, defaultValue: Boolean): Boolean {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getBoolean(key, defaultValue)
    }

    fun loadLong(key: String, defaultValue: Long): Long {
        val pref = BlindApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val value = pref.getString(key, java.lang.Long.toString(defaultValue))
        return java.lang.Long.parseLong(value!!)
    }

}
