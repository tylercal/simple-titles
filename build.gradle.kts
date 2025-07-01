import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

group = "com.roomj"
version = "1.6"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        create("IC", "2025.1")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
        }

        changeNotes = """
      <strong>1.6:</strong> Fix title update failure in new versions.<br>
      <strong>1.5:</strong> Update documenation with more details on how to customize titles.<br>
      <strong>1.4:</strong> Customize how the title is simplified with your own custom formats<br>
      <strong>1.3:</strong> Actually fix compatibility range<br>
      <strong>1.2:</strong> Try to Fix compatibility range<br>
      <strong>1.1:</strong> updating to use non-deprecated APIs<br>
      <strong>1.0:</strong> initial version<br>
    """.trimIndent()
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        javaParameters.set(true)
    }
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}
