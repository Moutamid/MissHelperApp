plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.moutamid.misshelper"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.moutamid.misshelper"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        setProperty("archivesBaseName", "MissHelper-$versionName")

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
//    implementation("com.github.qamarelsafadi:CurvedBottomNavigation:0.1.3")
    androidTestImplementation(libs.espresso.core)
}