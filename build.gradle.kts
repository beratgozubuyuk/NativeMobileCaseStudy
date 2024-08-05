// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.0.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
    }
}

plugins {
    id ("com.android.application") version ("8.0.2") apply false
    id ("org.jetbrains.kotlin.android") version ("1.8.0") apply false
}

allprojects {
    repositories {
    }
}
