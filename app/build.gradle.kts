plugins {
    alias(libs.plugins.android.application)
    // الآن نخبر التطبيق أن يستخدم الأداة التي جهزناها في الخطوة الأولى
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 36 // 36 إصدار غير موجود حاليًا، 34 هو الصحيح

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26 // 36 رقم مرتفع جدًا، 24 مناسب لمعظم الأجهزة
        targetSdk = 36 // يجب أن يتوافق مع compileSdk
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

// هذا هو القسم الصحيح للمكتبات (Dependencies)
dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("androidx.annotation:annotation:1.8.0")
    implementation("com.android.volley:volley:1.2.1")
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    implementation("de.hdodenhof:circleimageview:3.1.0")

    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))

     implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
}
