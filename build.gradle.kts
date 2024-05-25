plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.musinsa"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}