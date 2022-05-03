plugins {
    id("me.idriz.commando.java-conventions")
    `maven-publish`
}

dependencies {
    compileOnly("org.jetbrains:annotations:23.0.0")
}

description = "commando-core"

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            groupId = project.group.toString()
            artifactId = rootProject.name
            version = project.version.toString()

            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}