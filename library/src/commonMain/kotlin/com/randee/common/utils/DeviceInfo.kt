package com.randee.common.utils
/**
 * 设备类型
 */
enum class DeviceType {
    PHONE,
    PAD,
    TV,
    WATCH,
    CAR,
    PC
}
/**
 * 操作系统平台
 */
enum class Platform {
    ANDROID,
    IOS,
    HARMONY
}

data class DeviceInfo (
    val platform: Platform,
    val osName: String,
    val osVersion: String,
    val apiVersion: Int,
    val brand: String,
    val manufacturer: String,
    val model: String, // 设备型号
    val deviceType: String  // 设备类型
)

expect fun getDeviceInfo():DeviceInfo
