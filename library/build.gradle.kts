import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.randee"
version = "1.0.0"

kotlin {

    androidLibrary {
        namespace = "io.github.randee.common"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava() // enable java compilation support
        withHostTestBuilder {}.configure {}
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    iosArm64()
    iosSimulatorArm64()

    // 配置OHOS（华为鸿蒙）多架构目标
    listOf(
        ohosArm64(),   // 真机 arm64
    ).forEach { ohosTarget ->
        ohosTarget.binaries.sharedLib {
            baseName = "kn"
            linkerOpts("-lz")
            // 渲染模式
            // 背景：当 libkn.so 为旧编译产物时，其 DT_NEEDED 可能缺少以下库（正确构建时
            // NativeTasksConfiguration.kt 已通过 -l 选项将它们写入 DT_NEEDED）。
            // 在 build.gradle.kts 中统一补全，避免在 CMakeLists.txt 中硬编码。
            val rendererBackend =
                rootProject.findProperty("rendererBackend")?.toString() ?: "fusion-renderer"
            if (rendererBackend == "fusion-renderer") {
                linkerOpts(
                    "-lnative_drawing",    // OH_Drawing_*（字体、绘制）
                    "-limage_source",       // OH_ImageSourceNative_*（图像解码）
                    "-lpixelmap",           // OH_PixelMap_*
                    "-lpixelmap_ndk.z",     // OH_PixelMapNdk_*
                    "-lnative_window",      // OH_NativeWindow_*
                    "-lace_napi.z",         // N-API
                    "-lhilog_ndk.z",        // HiLog 日志
                    "-lhitrace_ndk.z",      // HiTrace 性能追踪
                    "-luv",                 // libuv 事件循环
                    "-lunwind",             // 栈展开
                    "-licu",               // ICU 文本处理
                )
            }
        }
    }



    sourceSets {

        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }


        androidMain.dependencies {

        }


        // iOS平台共享代码
        val iosMain = sourceSets.create("iosMain").apply {
            dependsOn(commonMain.get())
        }
        // iOS平台依赖
        iosMain.dependencies {
        }
        // iOS平台变体依赖关系
        listOf("iosArm64Main", "iosSimulatorArm64Main").forEach {
            sourceSets.getByName(it).dependsOn(iosMain)
        }

        // OHOS 共享（对应目录 src/ohosMain/，arm64/x64 共用）
        val ohosMain = sourceSets.create("ohosMain").apply {
            dependsOn(commonMain.get())
        }

        // 鸿蒙平台变体依赖关系
        listOf("ohosArm64Main").forEach {
            sourceSets.getByName(it).dependsOn(ohosMain)
        }
    }
}

//mavenPublishing {
//    publishToMavenCentral()
//
//    signAllPublications()
//
//    coordinates(group.toString(), "library", version.toString())
//
//    pom {
//        name = "My library"
//        description = "A library."
//        inceptionYear = "2026"
//        url = "https://github.com/kotlin/multiplatform-library-template/"
//        licenses {
//            license {
//                name = "XXX"
//                url = "YYY"
//                distribution = "ZZZ"
//            }
//        }
//        developers {
//            developer {
//                id = "XXX"
//                name = "YYY"
//                url = "ZZZ"
//            }
//        }
//        scm {
//            url = "XXX"
//            connection = "YYY"
//            developerConnection = "ZZZ"
//        }
//    }
//}
