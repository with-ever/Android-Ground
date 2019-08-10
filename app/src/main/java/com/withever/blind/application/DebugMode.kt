package com.withever.blind.application

class DebugMode {

    companion object {
        private var releaseMode: Boolean = false // true: 마켓 업로드 시 사용되는 버전, false: 개발 기간 때 사용되는 버전
        private var releaseAPIMode: ServerMode = ServerMode.PRODUCT   // true: 실서버, false: 개발서버
        private var showLog: Boolean = true // true: visible Log, false: gone Log
        private var showAPILog: Boolean = true // true: visible Log, false: gone Log

        fun releaseMode(mode: Mode) {
            releaseMode = mode == Mode.RELEASE
        }

        fun apiMode(mode: ServerMode) {
            releaseAPIMode = mode
        }

        fun showLog(isShow: Boolean) {
            showLog = isShow
            showAPILog = isShow
        }
    }

    enum class Mode {
        DEBUG, RELEASE
    }

    enum class ServerMode {
        PRODUCT, DEVELOP
    }
}