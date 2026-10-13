rootProject.name = "Compose_ohos"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
//        mavenCentral()
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-releases/")
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-public/")
        // 引入 Gradle 插件门户（主要用于查找 Gradle 插件）
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-releases/")
        maven("https://maven.eazytec-cloud.com/nexus/repository/maven-public/")
//        mavenCentral()
//        google()
    }
}
include(":library")
// library 模块位于 example 的上级目录，需显式指定 projectDir
project(":library").projectDir = file("../library")
include(":composeApp")
include(":androidApp")
