package com.randee.common.utils

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.BasicServicesKit.DeviceInfo.OH_GetOSFullName

class DeviceInfo():IDevice{

    override val name: String
        get() = "Harmony"

    @OptIn(ExperimentalForeignApi::class)
    override fun fullName():String {
        val value = OH_GetOSFullName()
        return value?.toKString() ?: ""
    }

}

actual fun getDeviceInfo() : IDevice= DeviceInfo()