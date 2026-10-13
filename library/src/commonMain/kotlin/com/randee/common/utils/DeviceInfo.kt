package com.randee.common.utils


interface IDevice {
    val name:String
    fun fullName():String
}

expect fun getDeviceInfo():IDevice
