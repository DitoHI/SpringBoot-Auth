import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.0.M3"
	id("io.spring.dependency-management") version "0.6.0.RELEASE"
	kotlin("jvm") version "1.3.31"
	kotlin("plugin.spring") version "1.3.31"
	id("org.jlleitschuh.gradle.ktlint") version "8.0.0"
	id("org.jlleitschuh.gradle.ktlint-idea") version "8.0.0"
}

group = "com.diaryquran"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	jcenter()
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.spring.io/milestone") }
	maven {
		url = uri("https://plugins.gradle.org/m2/")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jlleitschuh.gradle:ktlint-gradle:8.0.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// additional
	implementation("com.graphql-java:graphql-java:8.0")
	implementation("com.graphql-java:graphiql-spring-boot-starter:4.0.0")
	implementation("com.graphql-java:graphql-spring-boot-starter:4.0.0")
	implementation("com.graphql-java:graphql-java-tools:5.0.0")
	implementation("com.graphql-java:graphql-java-servlet:5.0.0")
	implementation("org.postgresql:postgresql:42.2.5")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.1.5.RELEASE")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

