plugins {
    id("com.sanjaya.buildlogic.app")
    id("com.sanjaya.buildlogic.compose")
}

android {
    namespace = "com.jessica.buddy"

    defaultConfig {
        applicationId = "com.jessica.buddy"
        versionCode = libs.versions.version.code.get().toInt()
        versionName = libs.versions.version.name.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
