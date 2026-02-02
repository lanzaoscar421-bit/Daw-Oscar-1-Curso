plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.33")
    // Source: https://mvnrepository.com/artifact/org.xhtmlrenderer/flying-saucer-pdf
    implementation("org.xhtmlrenderer:flying-saucer-pdf:10.0.6")
    // Source: https://mvnrepository.com/artifact/net.openhft/chronicle-bytes
    implementation("net.openhft:chronicle-bytes:2026.3")

}

tasks.test {
    useJUnitPlatform()
}