repositories {
    loadRepositories(project)
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(kotlin("reflect"))
    api("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.4.2")
    api("org.checkerframework", "checker-qual", "3.9.0")
    loadDependencies(project)
}

java {
    withJavadocJar()
}
