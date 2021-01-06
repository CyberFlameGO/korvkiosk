repositories {
    loadRepositories(project)
}

dependencies {
    loadDependencies(project)

    api(kotlin("stdlib-jdk8"))
    api(kotlin("reflect"))
    api("org.checkerframework", "checker-qual", "3.9.0")

    val coroutinesVersion = "1.4.2"
    api("org.jetbrains.kotlinx", "kotlinx-coroutines-core", coroutinesVersion)
    api("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8", coroutinesVersion)

    val cloudVersion = "1.3.0"
    api("cloud.commandframework", "cloud-paper", cloudVersion)
    api("cloud.commandframework", "cloud-kotlin-extensions", cloudVersion)
    api("cloud.commandframework", "cloud-minecraft-extras", cloudVersion)

    val configurateVersion = "4.0.0"
    api("org.spongepowered", "configurate-core", configurateVersion)
    api("org.spongepowered", "configurate-hocon", configurateVersion)
    api("org.spongepowered", "configurate-yaml", configurateVersion)

    val guiceVersion = "4.2.3"
    api("com.google.inject", "guice", guiceVersion) {
        exclude("com.google.guava", "guava")
    }
    api("com.google.inject.extensions", "guice-assistedinject", guiceVersion) {
        exclude("com.google.guava", "guava")
    }
}

java {
    withJavadocJar()
}
