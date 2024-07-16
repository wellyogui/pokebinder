import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id ("kotlin-android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

val apiKeyPropertiesFile = rootProject.file("apiKey.properties")
val apiKeyProperties = Properties()
apiKeyProperties.load(FileInputStream(apiKeyPropertiesFile))

android {
    namespace = "br.com.well.service"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        targetSdk = 34

        val apiKeyProperties = Properties().apply {
            load(project.rootProject.file("apiKey.properties").inputStream())
        }
        buildConfigField("String", "API_KEY", apiKeyProperties["API_KEY"].toString())
        buildConfigField("String", "BASE_URL", apiKeyProperties["BASE_URL"].toString())


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.gson)
    api(libs.timber)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}