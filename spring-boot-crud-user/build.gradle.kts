plugins {
    id("java")
}

group = "br.com.fiap"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.5")
    runtimeOnly("com.h2database:h2:2.1.214")
}

tasks.test {
    useJUnitPlatform()
}