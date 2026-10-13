package com.example.compose_ohos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getPlatformFullName():String

