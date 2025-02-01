import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val libs = the<LibrariesForLibs>()

plugins {
    id("java-library")
    id("kotlin")
    id("com.vanniktech.maven.publish")
}

repositories {
    mavenCentral()
    google()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType(KotlinCompile::class.java) {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

configurations.all {
    // Pin the kotlin version
    resolutionStrategy {
        force(libs.kotlin.stdlib)
        force(libs.kotlin.stdlib.jdk8)
        force(libs.kotlin.reflect)
    }
}
