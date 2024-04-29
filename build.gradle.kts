// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependency.Gradle.APPLICATION) version Versions.GRADLE apply false
    id(Dependency.Gradle.LIBRARY) version Versions.GRADLE apply false
    id(Dependency.Gradle.KOTLIN) version Versions.KOTLIN apply false
    id(Dependency.Hilt.HILT_PLUGIN) version Versions.HILT apply false
    id(Dependency.Google.GOOGLE_SERVICES_PLUGIN) version Versions.GOOGLE_SERVICE_PLUGIN apply false
    id(Dependency.Gradle.KSP) version Versions.KSP apply false
}

allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            if (project.findProperty("enableMultiModuleComposeReports") == "true") {
                freeCompilerArgs += listOf("-P", "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + rootProject.buildDir.absolutePath + "/compose_metrics/")
                freeCompilerArgs += listOf("-P", "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + rootProject.buildDir.absolutePath + "/compose_metrics/")
            }
        }
    }
}