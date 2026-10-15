package io.github.randee.common.utils
import android.os.Build

actual fun getDeviceInfo() = DeviceInfo(
    platform = Platform.ANDROID,
    osName = "Android",
    osVersion = Build.VERSION.RELEASE,
    apiVersion = Build.VERSION.SDK_INT,
    brand = Build.BRAND,
    manufacturer = Build.MANUFACTURER,
    model = Build.MODEL,
    deviceType = Build.DEVICE
)