plugins {
    id("com.sanjaya.buildlogic.lib")
    id("com.sanjaya.buildlogic.compose")
    kotlin("plugin.serialization") version core.versions.kotlin.core
}

android {
    namespace = "com.jessica.buddy.home"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        buildConfig = true
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
}
