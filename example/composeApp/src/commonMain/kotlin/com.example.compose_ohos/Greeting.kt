package com.example.compose_ohos

class Greeting {
    private val platform = getPlatform()

    private val osFullName = getPlatformFullName()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }


    fun fullName():String {
        return "当前平台名称:${osFullName}!"
    }
}