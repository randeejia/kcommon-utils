package com.randee.common.utils

import platform.UIKit.UIDevice

class DeviceInfo():IDevice{
    override val name: String
        get() = "Ios"
    override fun fullName():String {
        return UIDevice.currentDevice.systemName + " " + UIDevice.currentDevice.systemVersion
    }

}

actual fun getDeviceInfo() : IDevice= DeviceInfo()