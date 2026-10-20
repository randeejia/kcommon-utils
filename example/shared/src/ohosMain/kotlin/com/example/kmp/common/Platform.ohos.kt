package com.example.kmp.common
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.experimental.ExperimentalNativeApi
import platform.BasicServicesKit.DeviceInfo.OH_GetOSFullName
import kotlinx.cinterop.toKString
import platform.resource.add

@OptIn(ExperimentalNativeApi::class)
class OhosPlatform : Platform {
    @OptIn(ExperimentalForeignApi::class)
    override val name: String = "HarmonyOS ${add(2,3)}"
}

@OptIn(ExperimentalNativeApi::class)
actual fun getPlatform(): Platform = OhosPlatform()

@OptIn( ExperimentalForeignApi::class)
actual fun getPlatformFullName():String {
    val value = OH_GetOSFullName()
    return value?.toKString() ?: ""
}