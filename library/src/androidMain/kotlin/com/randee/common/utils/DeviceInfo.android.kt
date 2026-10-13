package com.randee.common.utils
import android.os.Build

class DeviceInfo():IDevice{
    override val name: String
        get() = "Android"
    override fun fullName():String = buildString {
        append("Android ${Build.VERSION.RELEASE}")
        append(" (API ${Build.VERSION.SDK_INT})")
    }

}

actual fun getDeviceInfo() : IDevice= DeviceInfo()