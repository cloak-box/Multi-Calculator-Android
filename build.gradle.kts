// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.android.library) apply false
}

buildscript {
  dependencies {
    classpath(libs.cloak.box.plugin.maven.api.plugin)
  }
}