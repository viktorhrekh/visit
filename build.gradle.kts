///////////////////////////////////////////////////////////////////////////
// Versions
///////////////////////////////////////////////////////////////////////////

val wrappersBom = "0.0.1-pre.312-kotlin-1.6.10"

///////////////////////////////////////////////////////////////////////////
// Settings
///////////////////////////////////////////////////////////////////////////

plugins {
    kotlin("js") version "1.6.20-RC"
}

group = "site.vie10"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
}

///////////////////////////////////////////////////////////////////////////
// Dependencies
///////////////////////////////////////////////////////////////////////////

dependencies {
    implementation(enforcedPlatform(kotlinw("wrappers-bom:$wrappersBom")))

    implementation(kotlinw("react"))
    implementation(kotlinw("react-dom"))
    implementation(kotlinw("react-css"))
    implementation(kotlinw("react-router-dom"))

    implementation(kotlinw("mui"))
    implementation(kotlinw("mui-icons"))

    implementation(npm("@emotion/react", "11.8.1"))
    implementation(npm("@emotion/styled", "11.8.1"))
}

///////////////////////////////////////////////////////////////////////////
// Helpers for beautify previous code
///////////////////////////////////////////////////////////////////////////

fun kotlinw(target: String): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"
