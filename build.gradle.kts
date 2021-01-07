import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

plugins {
    `java-library`
    kotlin("jvm") version "1.4.21-2"
    `maven-publish`
    toothpick
}

toothpick {
    forkName = "korvkiosk"
    groupId = "org.incendo"
    forkUrl = "https://github.com/Incendo/korvkiosk"
    val versionTag = System.getenv("BUILD_NUMBER")
        ?: "\"${gitCmd("rev-parse", "--short", "HEAD").output}\""
    forkVersion = "git-$forkName-$versionTag"

    minecraftVersion = "1.16.4"
    nmsPackage = "1_16_R3"
    nmsRevision = "R0.1-SNAPSHOT"

    upstream = "Purpur"
    upstreamBranch = "origin/ver/1.16.4"

    server {
        project = project(":$forkNameLowercase-server")
        patchesDir = rootProject.projectDir.resolve("patches/server")
    }
    api {
        project = project(":$forkNameLowercase-api")
        patchesDir = rootProject.projectDir.resolve("patches/api")
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://repo.aikar.co/content/groups/aikar/")
        maven("https://nexus.velocitypowered.com/repository/velocity-artifacts-snapshots/")
        maven("https://libraries.minecraft.net")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenLocal()
    }
}

subprojects {
    apply<KotlinPlatformJvmPlugin>()

    kotlin {
        explicitApi()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        withSourcesJar()
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    /* todo
    publishing.repositories.maven {
        url = uri("https://repo.pl3x.net/snapshots")
        credentials(PasswordCredentials::class)
    }
    */
}
