object Dependency {
    object Gradle {
        const val APPLICATION = "com.android.application"
        const val LIBRARY = "com.android.library"
        const val KOTLIN = "org.jetbrains.kotlin.android"
        const val KSP = "com.google.devtools.ksp"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
        const val COMPOSE_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.COMPOSE_LIFECYCLE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val SPLASH = "androidx.core:core-splashscreen:${Versions.SPLASH}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val COMPOSE = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val COMPOSE_MATERIAL3 = "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL3}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val COMPOSE_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.COMPOSE}"
        const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"
        const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:{${Versions.COMPOSE_FOUNDATION}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

        const val GOOGLE_SERVICES_PLUGIN = "com.google.gms.google-services"
        // FIREBASE

        const val SWIPE_REFRESH ="com.google.accompanist:accompanist-swiperefresh:${Versions.SWIPE_REFRESH}"
    }

    object Coil {
        const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    }

    object OkHttp {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object Hilt {
        const val HILT_PLUGIN = "com.google.dagger.hilt.android"
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val HILT_NAVIGATION_FRAGMENT = "androidx.hilt:hilt-navigation-fragment:${Versions.HILT_NAVIGATION}"
        const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    }

    object Gauth {
        const val GAUTH = "com.github.GSM-MSG:GAuth-Signin-Android:${Versions.GAUTH}"
    }

    object DataStore {
        const val PREFERENCES = "androidx.datastore:datastore-preferences:${Versions.PREFERENCES}"
    }
}