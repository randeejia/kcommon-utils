package com.example.compose_ohos
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.experimental.ExperimentalNativeApi
import platform.BasicServicesKit.DeviceInfo.OH_GetOSFullName
import kotlinx.cinterop.toKString

@OptIn(ExperimentalNativeApi::class)
class OhosPlatform : Platform {
    override val name: String = "HarmonyOS"
}

@OptIn(ExperimentalNativeApi::class)
actual fun getPlatform(): Platform = OhosPlatform()

@OptIn( ExperimentalForeignApi::class)
actual fun getPlatformFullName():String {
    val value = OH_GetOSFullName()
    return value?.toKString() ?: ""
}