plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.23"
    kotlin("plugin.jpa") version "1.9.23"
    kotlin("kapt")
}

group = "com.musinsa"
version = "1.0-SNAPSHOT"

val querydslVersion = "5.1.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("io.github.openfeign.querydsl:querydsl-jpa:${querydslVersion}:jakarta")
    kapt("io.github.openfeign.querydsl:querydsl-apt:${querydslVersion}:jakarta")
    kapt("io.github.openfeign.querydsl:querydsl-kotlin-codegen:${querydslVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    runtimeOnly("com.h2database:h2:2.2.224")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

allOpen {
    annotation("jakarta.persistence.Entity")
}

tasks {
    bootJar { enabled = false }
    jar { enabled = true }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
