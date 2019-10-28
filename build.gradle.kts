import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    base
    kotlin("jvm") version Shared.KOTLIN_VERSION
    id("org.jmailen.kotlinter") version "1.20.1"

    id("com.github.ben-manes.versions") version "0.20.0"
    `maven-publish`
}

allprojects {
    group = "com.betfair.tline"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven { url = URI("https://plugins.gradle.org/m2/") }
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.javaParameters = true
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "jacoco")
    apply(plugin = "maven-publish")

    configure<JacocoPluginExtension> {
        toolVersion = "0.8.2"
    }

    tasks.withType<JacocoReport>().configureEach {
        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    dependencies {
        "implementation"(kotlin("stdlib-jdk8"))
        "implementation"("io.github.microutils:kotlin-logging:1.6.26")

        "implementation"("com.google.inject:guice:4.2.2")
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")

        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit:${Shared.KOTLIN_VERSION}")
        "testImplementation"("org.junit.jupiter:junit-jupiter-api:${Shared.JUNIT_VERSION}")
        "testImplementation"("io.mockk:mockk:1.9.3")
        "testImplementation"("com.google.truth:truth:1.0")
        "testRuntime"("org.junit.jupiter:junit-jupiter-engine:${Shared.JUNIT_VERSION}")
    }

    configurations.all {
        resolutionStrategy.preferProjectModules()
    }

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}
