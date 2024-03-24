plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.englishsummary"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.englishsummary"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.car.ui:car-ui-lib:2.6.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")

    //Material UI
    implementation ("com.android.support:design:28.0.0")
//
//    // Annotation processor
//    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.7.0")
//    // alternately - if using Java8, use the following instead of lifecycle-compiler
//    implementation("androidx.lifecycle:lifecycle-common-java8:2.7.0")
//
//    // optional - helpers for implementing LifecycleOwner in a Service
//    implementation("androidx.lifecycle:lifecycle-service:2.7.0")
//
//    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
//    implementation("androidx.lifecycle:lifecycle-process:2.7.0")
//
//    // optional - ReactiveStreams support for LiveData
//    implementation("androidx.lifecycle:lifecycle-reactivestreams:2.7.0")
//
//    // optional - Test helpers for LiveData
//    testImplementation("androidx.arch.core:core-testing:2.2.0")
//
//    // optional - Test helpers for Lifecycle runtime
//    testImplementation("androidx.lifecycle:lifecycle-runtime-testing:2.7.0")

//    // Annotation processor
//    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")
}