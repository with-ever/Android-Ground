package com.withever.blind.extension

import java.util.regex.Pattern

fun isValidEmail(email: String): Boolean {
    val mailRegex = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$"
    val pattern = Pattern.compile(mailRegex)
    val mather = pattern.matcher(email)
    return mather.find()
}

fun isValidUserName(name: String): Boolean {
    val mailRegex = "^[a-zA-Z0-9]+$"
    val pattern = Pattern.compile(mailRegex)
    val mather = pattern.matcher(name)
    return mather.find()
}