package com.withever.blind.utils

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Environment
import android.util.DisplayMetrics
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

object SystemUtils {

    /**----------------------------------------------------
     * Device information
     *----------------------------------------------------*/
    // 버전 코드
    fun getVersionCode(context: Context, packageName: String): Int {
        var v = 0
        try {
            v = context.packageManager.getPackageInfo(packageName, 0).versionCode
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return v
    }

    // 기기에 설정된 국가 정보
    fun getDeviceCountryCode(): String {
        return Locale.getDefault().country
    }

    // 기기에 설정된 언어 정보
    fun getDeviceLanguageCode(context: Context): String {
        return Locale.getDefault().toString()
    }

    // 기기에 설정된 Locale 정보
    fun getDeviceLocale(context: Context): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales.get(0)
        } else {
            context.resources.configuration.locale
        }
    }


    /**----------------------------------------------------
     * Resolution
     *----------------------------------------------------*/
    fun getScreenWidth(): Int = Resources.getSystem().displayMetrics.widthPixels
    fun getScreenHeight(): Int = Resources.getSystem().displayMetrics.heightPixels
    fun getDeviceDpi(): Int = Resources.getSystem().displayMetrics.densityDpi
    fun getDeviceDensity(): Float = Resources.getSystem().displayMetrics.density
    fun getDeviceInch(): Double {
        val dm = Resources.getSystem().displayMetrics
        val density = dm.density * 160
        val x = Math.pow((dm.widthPixels / density).toDouble(), 2.0)
        val y = Math.pow((dm.heightPixels / density).toDouble(), 2.0)
        return Math.sqrt(x + y)
    }

    fun convertDp2Pixel(dp: Float, context: Context) : Float{
        return dp * (getDeviceDpi() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun convertPixel2Dp(px: Float, context: Context) : Float{
        return px / (getDeviceDpi() / DisplayMetrics.DENSITY_DEFAULT)
    }

    /**----------------------------------------------------
     * Time zone
     *----------------------------------------------------*/
    fun getCurrentTimezoneOffset(): String {
        val mCalendar = GregorianCalendar()
        val mTimeZone = mCalendar.timeZone
        val mGMTOffset = -mTimeZone.rawOffset

        return TimeUnit.MINUTES.convert(mGMTOffset.toLong(), TimeUnit.MILLISECONDS).toString()
    }


    /**----------------------------------------------------
     * Time zone
     *----------------------------------------------------*/
    fun getRandomCode(length: Int): String {
        val rnd = Random()
        val buf = StringBuffer()

        for (i in 0 until length) {
            if (rnd.nextBoolean()) {
                buf.append((rnd.nextInt(26) + 97).toChar())
            } else {
                buf.append(rnd.nextInt(10))
            }
        }

        return buf.toString()
    }



    /**----------------------------------------------------
     * 숫자 표기 (k, m, b)
     *----------------------------------------------------*/
    fun displayCount(count: Int): String {
        var countStr: String = when {
            count >= 1000000000 -> "%.1fb".format(count.toFloat() / 1000000000)
            count >= 1000000 -> "%.1fm".format(count.toFloat() / 1000000)
            count >= 1000 -> "%.1fk".format(count.toFloat() / 1000)
            else -> "$count"
        }

        if (!countStr.contains(".0")) return countStr
        countStr = countStr.replace(".0", "")
        return countStr
    }


    fun createFolder(folderName: String) {
        val dirPath = Environment.getExternalStorageDirectory().absolutePath + "/" + folderName
        val file = File(dirPath)
        if (!file.exists()) {
            file.mkdirs()
        }
    }

}