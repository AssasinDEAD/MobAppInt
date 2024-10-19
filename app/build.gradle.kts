plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.testmobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testmobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {
    // Core Android libraries
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.activity.compose.v172)

    // Compose BOM (Bill of Materials) to manage Compose versions
    implementation(libs.androidx.compose.bom.v20240100)

    // Compose UI components
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.ui.graphics)
    implementation(libs.material3)

    // Coil for image loading in Compose
    implementation(libs.coil.compose)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v121)
    androidTestImplementation(libs.androidx.espresso.core.v361)
    androidTestImplementation(libs.androidx.compose.bom.v20240902)
    androidTestImplementation(libs.ui.test.junit4)

    // Debugging tools for Compose
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
