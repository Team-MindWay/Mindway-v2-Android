import java.io.FileInputStream
import java.util.Properties

plugins {
    id(Dependency.Gradle.KOTLIN)
    id(Dependency.Gradle.LIBRARY)
    id(Dependency.Hilt.HILT_PLUGIN)
    id(Dependency.Gradle.KSP)
}

android {
    namespace = ProjectProperties.NameSpace.PRESENTATION
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARD_FILES)

        buildConfigField("String","CLIENT_ID", getApiKey("CLIENT_ID"))

        buildConfigField("String", "REDIRECT_URI", getApiKey("REDIRECT_URI"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARD_FILES),
                ProjectProperties.Files.PROGUARD_FILES
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.AndroidX.SPLASH)


    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(platform(Dependency.Compose.COMPOSE_BOM))
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_GRAPHICS)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_NAVIGATION)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)

    implementation(Dependency.Hilt.HILT)
    ksp(Dependency.Hilt.HILT_COMPILER)
    implementation (Dependency.Hilt.HILT_NAVIGATION_FRAGMENT)
    implementation (Dependency.Hilt.HILT_NAVIGATION_COMPOSE)

    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    androidTestImplementation(platform(Dependency.Compose.COMPOSE_BOM))
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)

    implementation(Dependency.Gauth.GAUTH)
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}