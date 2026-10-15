package io.github.randee.common.utils

import platform.UIKit.UIDevice


actual fun getDeviceInfo() : DeviceInfo = DeviceInfo(
    platform = Platform.IOS,
    osName = UIDevice.currentDevice.systemName,
    osVersion = UIDevice.currentDevice.systemVersion,
    apiVersion = -1,
    brand = "Apple",
    manufacturer = "Apple",
    model = UIDevice.currentDevice.model,
    deviceType = UIDevice.currentDevice.localizedModel
)