package com.withever.blind.extension

import java.text.SimpleDateFormat
import java.util.*

fun getDate(millisecond: Long?, formatString: String): String {
    val date = getDateFromUnixTime(millisecond!!)
    val format = SimpleDateFormat(formatString)
    return getTimerZeroString(format.format(date).toInt())
}

fun getDateFromUnixTime(millisecond: Long): Date {
    val check = millisecond.toString()
    return if (check.length < 13) {
        Date(millisecond * 1000)
    } else {
        Date(millisecond)
    }
}

fun getTimerZeroString(time: Int): String {
    var result = time.toString()
    if (result.length == 1) {
        result = "0$result"
    }
    return result
}

fun getDateUnixTime(millisecond: Long?, formatString: String): String {
    val date = getDateFromUnixTime(millisecond!!)
    val format = SimpleDateFormat(formatString)
    return format.format(date)
}