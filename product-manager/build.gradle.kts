plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.musinsa"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation(project(path = ":product-domain-rdb"))
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}