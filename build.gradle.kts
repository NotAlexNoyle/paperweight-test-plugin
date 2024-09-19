repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.jpenilla.xyz/snapshots/")
}

plugins {
  java
  eclipse
  id("io.papermc.paperweight.userdev") version "1.7.2"
  id("xyz.jpenilla.run-paper") version "2.3.0" // Adds runServer and runMojangMappedServer tasks for testing
}

group = "io.papermc.paperweight"
version = "1.0.0-SNAPSHOT"
description = "Test plugin for paperweight-userdev"

java {
    // Use JDK 17 for 1.19.4 compatibility
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

dependencies {
    // Use the Paper 1.19.4 dev bundle
    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.release.set(17) // Set Java version to 17
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    reobfJar {
        outputJar.set(layout.buildDirectory.file("libs/PaperweightTestPlugin-${project.version}.jar"))
    }
}

