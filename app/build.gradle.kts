plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.nativemobilecasestudy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nativemobilecasestudy"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Room dependencies
    implementation (libs.androidx.room.runtime)
    kapt (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx.v252)

    // Glide for image loading
    implementation (libs.glide)
    kapt (libs.compiler)

    // Navigation components
    implementation (libs.androidx.navigation.fragment.ktx.v260)
    implementation (libs.androidx.navigation.ui.ktx.v260)

    // Retrofit for network requests
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // AndroidX dependencies
    implementation (libs.androidx.core.ktx.v1101)
    implementation (libs.androidx.appcompat.v161)
    implementation (libs.material.v190)
    implementation (libs.androidx.activity.ktx)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.androidx.legacy.support.v4)
    implementation (libs.androidx.lifecycle.livedata.ktx.v261)
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v261)
    implementation (libs.androidx.fragment.ktx.v161)

    // Test dependencies
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit.v115)
    androidTestImplementation (libs.androidx.espresso.core.v351)
}
