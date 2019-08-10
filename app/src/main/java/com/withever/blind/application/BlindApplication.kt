package com.withever.blind.application

import android.app.Application
import android.content.Context
import com.withever.blind.application.DebugMode.Mode
import com.withever.blind.application.DebugMode.ServerMode

class BlindApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: BlindApplication? = null

        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        // Release Mode (DEBUG: 개발환경, RELEASE: 배포환경)
        DebugMode.releaseMode(Mode.DEBUG)

        // Server Mode (DEVELOP: 개발서버, PRODUCT: 실서버)
        DebugMode.apiMode(ServerMode.DEVELOP)

        // AppLog (true: Show Log, false: Hide Log)
        DebugMode.showLog(true)
    }


}