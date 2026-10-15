package io.github.randee.common.utils

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.BasicServicesKit.DeviceInfo.OH_GetOSFullName
import platform.BasicServicesKit.DeviceInfo.OH_GetDeviceType
import platform.BasicServicesKit.DeviceInfo.OH_GetBrand
import platform.BasicServicesKit.DeviceInfo.OH_GetManufacture
import platform.BasicServicesKit.DeviceInfo.OH_GetHardwareModel
import platform.BasicServicesKit.DeviceInfo.OH_GetSdkApiVersion

@OptIn(ExperimentalForeignApi::class)
actual fun getDeviceInfo()  = DeviceInfo(
    platform = Platform.HARMONY,
    osName = "HarmonyOS",
    osVersion = OH_GetOSFullName()?.toKString() ?: "未知",
    apiVersion = OH_GetSdkApiVersion(),
    brand = OH_GetBrand()?.toKString() ?: "未知",
    manufacturer = OH_GetManufacture()?.toKString() ?: "未知",
    model = OH_GetHardwareModel()?.toKString() ?: "未知",
    deviceType = OH_GetDeviceType()?.toKString() ?: "未知",
)