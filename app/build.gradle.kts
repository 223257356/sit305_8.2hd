plugins {
    id("com.sanjaya.buildlogic.app")
    id("com.sanjaya.buildlogic.compose")
}

android {
    namespace = "com.jessica.buddy.app"

    defaultConfig {
        applicationId = "com.jessica.buddy.app"
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

dependencies {
    implementation(project(":core"))
    implementation(project(":features:auth"))
    implementation(project(":features:home"))
    implementation(project(":features:article"))
    implementation(project(":features:profile"))
    implementation(project(":features:chat"))
}
