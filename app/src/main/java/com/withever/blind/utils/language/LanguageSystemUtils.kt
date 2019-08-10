package com.withever.blind.utils.language

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.withever.blind.utils.PreferencesUtils
import java.util.*


const val KEY_LOCAL_LANGUAGE = "key.local_language"

//기본 locale get
/**----------------------------------------------------
 * Locale
 *----------------------------------------------------*/
// 언어에 따른 지역 정보 가져오기
fun getLocale(code: String): Locale {
    return Locale.KOREA
//    return when (code) {
//        HiCharisConstants.Language.ZH_CN -> Locale.SIMPLIFIED_CHINESE
//        HiCharisConstants.Language.ZH_TW -> Locale.TRADITIONAL_CHINESE
//        HiCharisConstants.Language.TH -> Locale("th", "TH")
//        HiCharisConstants.Language.EN -> Locale.US
//        HiCharisConstants.Language.ID -> Locale("id", "ID")
//        else -> Locale.US
//    }
}


/**----------------------------------------------------
 * Language
 *----------------------------------------------------*/
// 언어 코드 변경
fun changeLanguage(context: Context, locale: Locale): Context {
    Locale.setDefault(locale)
    val config = Configuration()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        config.setLocale(locale)
        // FIXME
        //config.locales = LocaleList(locale)
        context.createConfigurationContext(config)
    } else {
        config.locale = locale
    }
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    return context
}

// 기기 언어 정보 설정
fun setLocalLanguage(context: Context, code: String) {
    PreferencesUtils.saveString(KEY_LOCAL_LANGUAGE, code)
}

fun setLocalLanguage(code: String) {
    PreferencesUtils.saveString(KEY_LOCAL_LANGUAGE, code)
}


// 기기 언어 정보 가져오기
fun getLocalLanguage(context: Context): String {
    return PreferencesUtils.loadString(KEY_LOCAL_LANGUAGE, "")!!
}

fun getLocalLanguage(): String {
    return PreferencesUtils.loadString(KEY_LOCAL_LANGUAGE, "")!!
}