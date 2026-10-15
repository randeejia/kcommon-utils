package com.example.kmp.common

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getPlatformFullName():String

