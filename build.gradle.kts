import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    application
}

group = "me.james"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.7.0")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "15"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}
