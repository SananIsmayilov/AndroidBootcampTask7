plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")

}

android {
    namespace = "com.sananismayilov.todoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sananismayilov.todoapp"
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
    dataBinding {
        enable = true
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //room db
    implementation ("androidx.room:room-runtime:2.6.0-rc01")
    kapt("androidx.room:room-compiler:2.6.0-rc01")
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    //viewmodel

    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    val lifecycle_version = "2.0.0"

// ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")

    implementation( "androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
// alternatively - Lifecycles only (no ViewModel or LiveData). Some UI
//     AndroidX libraries use this lightweight import for Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime:$lifecycle_version")

    annotationProcessor ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    //lottie anim
    val lottieVersion = "3.4.0"
    implementation ("com.airbnb.android:lottie:$lottieVersion")



}