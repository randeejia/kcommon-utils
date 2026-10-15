package com.example.kmp.common

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


actual fun getPlatformFullName():String = buildString {
        append("Android ${Build.VERSION.RELEASE}")
        append(" (API ${Build.VERSION.SDK_INT})")
    }