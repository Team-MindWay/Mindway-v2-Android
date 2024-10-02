import java.io.FileInputStream
import java.util.Properties

plugins {
    id(Dependency.Gradle.APPLICATION)
    id(Dependency.Gradle.KOTLIN)
    id(Dependency.Hilt.HILT_PLUGIN)
    id(Dependency.Gradle.KSP)
}

android {
    namespace = ProjectProperties.NameSpace.APP
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectProperties.Id.APPLICATION_ID
        minSdk = ProjectProperties.Versions.MIN_SDK
        targetSdk = ProjectProperties.Versions.TARGET_SDK
        versionCode = ProjectProperties.Versions.VERSION_CODE
        versionName = ProjectProperties.Versions.VERSION_NAME

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
        flavorDimensions.add("url")
        productFlavors {
            create("dev") {
                dimension = "url"
                buildConfigField(
                    "String",
                    "BASE_URL",
                    getApiKey("BASE_URL")
                )
            }
            // TODO: 본서버
        }
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.AndroidX.SPLASH)

    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(platform(Dependency.Compose.COMPOSE_BOM))
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_GRAPHICS)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_NAVIGATION)
    androidTestImplementation(platform(Dependency.Compose.COMPOSE_BOM))
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)

    implementation(Dependency.Hilt.HILT)
    ksp(Dependency.Hilt.HILT_COMPILER)

    implementation(Dependency.DataStore.PREFERENCES)

    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.OkHttp.OKHTTP)
    implementation(Dependency.OkHttp.OKHTTP_LOGGING_INTERCEPTOR)

    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)

    implementation(Dependency.Moshi.MOSHI)
    implementation(Dependency.Moshi.MOSHI_CONVERTER)
    ksp(Dependency.Moshi.MOSHI_CODEGEN)

    debugImplementation("com.readystatesoftware.chuck:library:1.1.0")
    releaseImplementation("com.readystatesoftware.chuck:library-no-op:1.1.0")
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}