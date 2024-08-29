plugins {
     alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
  id("com.black.cat.plugin.AndroidApiPublishPlugin")
}

android {
    namespace = "com.darkempire78.opencalculator"
    compileSdk = 34

    defaultConfig {
        resourceConfigurations += listOf("ar", "az", "be", "bn", "bs", "cs", "de", "el", "es", "fa", "fr", "hi", "hr", "hu", "in", "it", "ja", "kn", "mk", "ml", "nb-rNO", "nl", "or", "pl", "pt-rBR", "ro", "ru", "sat", "sr", "sv", "tr", "uk", "vi", "zh-rCN", "zh-rHK", "zh-rTW")
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
      buildConfigField("String", "VERSION_NAME", "\"3.1.0-beta1\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }

    viewBinding {
        enable = true
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidslidinguppanel)
    implementation(libs.androidx.preference.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.gson)
}


mavenPublishing {
  mavenConfig {
    groupId = "io.github.cloak-box.library"
    artifactId = "calc"
    version = "1.0.0"
    publishJavadocJar = false
    poublicSourcesJar = false
    mavenRepo = "release"
    mavenCentralUsername = "HXHDcYLK"
    mavenCentralPassword = "eUYcLhb0pWe6gxjf2YHHx1akzHWM2oBiFeCE3zQjs4UZ"

    pom {
      name.set("cloak box")
      description.set("A description of what my library does.")
      inceptionYear.set("2020")
      url.set("https://github.com/cloak-box/Vbox")
      licenses {
        license {
          name.set("GNU GENERAL PUBLIC LICENSE , Version 3, 29 June 2007")
          url.set("https://www.gnu.org/licenses/gpl-3.0.en.html#license-text")
          distribution.set("https://www.gnu.org/licenses/gpl-3.0.en.html#license-text")
        }
      }
      developers {
        developer {
          id.set("cloak box")
          name.set("cloak box")
          url.set("https://github.com/cloak-box")
        }
      }
      scm {
        url.set("https://github.com/cloak-box/Vbox")
        connection.set("scm:git:git://github.com/cloak-box/Vbox.git")
        developerConnection.set("scm:git:ssh://git@github.com/cloak-box/Vbox.git")
      }
    }
  }
}