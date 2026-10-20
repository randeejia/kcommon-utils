rootProject.name = "kcommon_utils"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()

        // 腾讯软件源
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-releases/")
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-public/")

        // 引入 Gradle 插件门户（主要用于查找 Gradle 插件）
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        // 腾讯软件源
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-releases/")
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-public/")
    }
}

include(":library")
