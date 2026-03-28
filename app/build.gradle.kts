plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.android.eyedropper.shortcut"
    compileSdkPreview = "CinnamonBun"

    defaultConfig {
        applicationId = "com.android.eyedropper.shortcut"
        minSdkPreview = "CinnamonBun"
        targetSdkPreview = "CinnamonBun"
        versionCode = 2
        versionName = "1.1"

        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    signingConfigs {
        create("release") {
            val storeFile = file("release_key.jks")
            val storePassword = System.getenv("KEY_STORE_PASSWORD")
            val keyAlias = System.getenv("KEY_STORE_ALIAS")
            val keyPassword = System.getenv("KEY_STORE_PASSWORD")

            if (storeFile.exists() && !storePassword.isNullOrBlank() && !keyAlias.isNullOrBlank() && !keyPassword.isNullOrBlank()) {
                this.storeFile = storeFile
                this.storePassword = storePassword
                this.keyAlias = keyAlias
                this.keyPassword = keyPassword
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlin {
        jvmToolchain(21)
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.appcompat)
}