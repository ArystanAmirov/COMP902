import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    application
}

group = "me.ari"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.25.0")
    implementation("com.sikulix:sikulixapi:2.0.5")
    implementation("org.testcontainers:testcontainers:1.19.7")
    implementation("org.testng:testng:7.7.0")
    implementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.10")

    implementation("org.seleniumhq.selenium:selenium-java:4.18.1")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

application {
    mainClass.set("ms_playwright.runner.MainKt")
}

tasks.shadowJar {
    archiveClassifier.set("")
    manifest {
        attributes["Main-Class"] = "ms_playwright.runner.MainKt"
    }
}


