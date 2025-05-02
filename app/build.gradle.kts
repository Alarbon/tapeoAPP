import java.text.SimpleDateFormat
import java.util.Date
import com.android.build.gradle.internal.api.ApkVariantOutputImpl


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)


}

val appName = "tapeoApp"
val appVersionCode = 1
val appVersionName = "1.0.0"

android {
    namespace = "com.alarbon.tapeoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alarbon.tapeoapp"
        minSdk = 24
        targetSdk = 35
        versionCode = appVersionCode
        versionName = appVersionName
        resValue("string", "app_name", appName)

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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }



    applicationVariants.all {
        outputs.all {
            val date = SimpleDateFormat("yyyyMMdd").format(Date())
            val buildTypeName = buildType.name
            val apkName = "${appName}-${appVersionName}-${date}-${buildTypeName}.apk"
            (this as ApkVariantOutputImpl).outputFileName = apkName
        }
    }



}
  

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.google.material)

        // Hilt
        implementation(libs.hilt.android)
        ksp(libs.hilt.android.compiler)
        ksp(libs.androidx.room.compiler)


        // Room
        implementation(libs.androidx.room.runtime)
        implementation(libs.androidx.room.ktx)

        // Navigation
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)

        // Lifecycle
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)

        // Coroutines
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        // Testing
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.activity.compose)
        implementation(libs.androidx.ui)
        implementation(libs.androidx.material3)
        implementation(libs.androidx.ui.tooling.preview)
        debugImplementation(libs.androidx.ui.tooling)
    }
