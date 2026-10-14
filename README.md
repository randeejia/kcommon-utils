# KMP 库 模版

## 简介

本库基于GitHub开源库[multiplatform-library-template](https://github.com/Kotlin/multiplatform-library-template)改造，支持Android、iOS、鸿蒙平台构建应用，以实现一码三端开发目的的库模版。


## 项目结构


    Android App         Harmony App         iOS App
        ｜                   ｜                ｜
        ｜                   ｜                ｜
        ｜                   ｜                ｜
        ----------------------------------------

                             

## 核心工具版本兼容性要求

### 工具清单

|名称|版本|备注|
|---|---|---|
|Java|21|Java 17+ |
|Gradle|8.13|-|
|Kotlin|2.2.21-1.1.0|---|
|K2|-|Kotlin编译器，Compose compiler依赖工具|

### Gradle插件及核心库清单

|名称|版本|备注|
|---|---|---|
|AGP|8.11.1|-|
|KGP|2.2.21-1.1.0|插件,和Kotlin版本保持一一致|
|KMP|2.2.21-1.1.0|插件,和Kotlin版本保持一一致|
|CMP|1.9.2-1.1.0|插件,|
|Compose compiler|2.2.21-1.1.0|插件,和Kotlin版本保持一一致|
|Skiko|0.9.22.2-1.1.0|插件，鸿蒙架构目标|

## API

### DeviceInfo




# 参考资料
- [Kotlin](https://kotlinlang.org/docs/home.html)
- [Kotlin/Native](https://kotlinlang.org/docs/native-overview.html)
- [Kotlin Interoperability with C](https://kotlinlang.org/docs/native-c-interop.html)
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform/get-started.html)
- [Compose Multiplatform](https://kotlinlang.org/compose-multiplatform/)
- [CPF-KMP-CMP](https://gitcode.com/CPF-KMP-CMP/docs)

