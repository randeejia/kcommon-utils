package com.example.compose_ohos

import com.randee.common.utils.getDeviceInfo

class DeviceInfo {
    private val platform = getDeviceInfo()

    fun name(): String {
        return "Hello, DeviceInfo:${platform.name}"
    }

    fun fullName():String {
        return "DeviceInfo:${platform.fullName()}!"
    }

}